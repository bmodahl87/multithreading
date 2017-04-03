package edu.matc.multithreading;

import java.util.Date;


/**
 * Created by bmodahl on 4/3/17.
 */
public class Child implements Runnable {

    String name;
    Date inTime;

    Home home;



    public Child(Home home)
    {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        goForTreat();
    }
    private synchronized void goForTreat()
    {
        home.add(this);
    }
}
