package Tutorium4;

import java.util.concurrent.Semaphore;

public class Discounter {
    static int kundenZahl = 20;
    static Discounter aldi = new Discounter();

    public static Semaphore einkaufswagen = new Semaphore(4);

    public boolean einkaufen(Kunde kunde) {
        try{
            einkaufswagen.acquire();
            System.out.println("discounter.Kunde " + kunde.kundenNr + " darf einkaufen");
            Thread.sleep(1000 + (int) (Math.random() * 4000));

            System.out.println("discounter.Kunde " + kunde.kundenNr + " geht");
             einkaufswagen.release();
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < kundenZahl; i++) {
            new Kunde(i, aldi).start();
        }
    }
}