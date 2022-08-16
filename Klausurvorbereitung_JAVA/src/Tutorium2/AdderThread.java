package Tutorium2;

public class AdderThread extends Thread {


    @Override
    public void run() {


        System.out.println(this.getName() + " reads counter: " + RmwRaceCondition.counter);
        int count = RmwRaceCondition.counter;
        RmwRaceCondition.counter = count + 1;
        System.out.println(this.getName() + " increased counter: " + RmwRaceCondition.counter);

    }
}