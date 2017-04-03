package edu.matc.multithreading;

/**
 * Created by bmodahl on 4/3/17.
 */
public class Halloween {
    public static void main(String a[])
    {
        Home home = new Home();

        Riley riley = new Riley(home);
        ChildGenerator cg = new ChildGenerator(home);

        Thread thriley = new Thread(riley);
        Thread thcg = new Thread(cg);
        thriley.start();
        thcg.start();
    }
}
