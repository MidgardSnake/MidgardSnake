package Tutorium1;

public class Main {


    public static void main(String[] args) {
        Thread a = new Thread(new Aufgabe1("A"));
        Thread b = new Thread( new Aufgabe1("B"));

        a.start();
        b.start();
    }
}
