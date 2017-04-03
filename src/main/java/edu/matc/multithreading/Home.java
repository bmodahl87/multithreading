package edu.matc.multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by bmodahl on 4/3/17.
 */
public class Home {

    int position;
    List<Child> ChildList;

    public Home()
    {
        position = 10;
        ChildList = new LinkedList<Child>();
    }

    public void trickOrTreat()
    {
        Child child;

        synchronized (ChildList)
        {

            while(ChildList.size()==0)
            {
                System.out.println("Riley watches TV.");
                try
                {
                    ChildList.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Trick-or-treater is at door.");
            child = (Child)((LinkedList<?>)ChildList).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Riley answers the door.");
            System.out.println("Riley gives candy to child  "+ child.getName());

            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley gives candy to child  "+ child.getName());
    }

    public void add(Child child)
    {
        System.out.println("Child "+ child.getName()+ " is at the door. ");

        synchronized (ChildList)
        {
            if(ChildList.size() == position)
            {
                System.out.println(child.getName() + " is waiting in line.");
                System.out.println("Child  "+ child.getName()+" skips this house...");
                return ;
            }

            ((LinkedList<Child>)ChildList).offer(child);
            System.out.println("Child "+ child.getName()+ " rings the doorbell.");

            if(ChildList.size()==1)
                ChildList.notify();
        }
    }
}
