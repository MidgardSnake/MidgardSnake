package Tutorium1;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 extends Aufgabe2 implements Runnable {

    List list = new ArrayList<Integer>();

    String name = "";

    public Aufgabe1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (name) {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ": " + i);

            }
        }
    }
}
