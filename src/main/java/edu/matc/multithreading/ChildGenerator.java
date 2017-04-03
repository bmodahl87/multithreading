package edu.matc.multithreading;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by bmodahl on 4/3/17.
 */
public class ChildGenerator implements Runnable {

    Home home;

    public ChildGenerator(Home home)
    {
        this.home = home;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(home);
            child.setInTime(new Date());
            Thread thchild = new Thread(child);
            child.setName("Child Thread "+thchild.getId());
            thchild.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*40));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
