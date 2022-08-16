package Tutorium3;

import Tutorium2.RmwRaceCondition;

public class AdderThread extends Thread {

    public Object monitor = new Object() ;

    @Override
    public void run() {

        synchronized (monitor) {
            System.out.println(this.getName() + " reads counter: " + Tutorium2.RmwRaceCondition.counter);
            int count = Tutorium2.RmwRaceCondition.counter;
            Tutorium2.RmwRaceCondition.counter = count + 1;
            System.out.println(this.getName() + " increased counter: " + RmwRaceCondition.counter);
        }
    }
}