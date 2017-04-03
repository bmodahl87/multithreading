package edu.matc.multithreading;

/**
 * Created by bmodahl on 4/3/17.
 */
class Riley implements Runnable {

    Home home;

    public Riley(Home home)
    {
        this.home = home;
    }
    public void run()
    {

        System.out.println("Halloween started..");
        while(true)
        {
            home.trickOrTreat();
        }
    }
}
