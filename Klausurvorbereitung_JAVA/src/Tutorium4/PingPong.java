package Tutorium4;

import java.util.concurrent.Semaphore;

public class PingPong extends Thread {

    public static final Object monitor = new Object();

    private boolean isPing;

    private static final Semaphore s = new Semaphore(2,true);

    public PingPong(boolean isPing) {
        this.isPing = isPing;
    }

    @Override
    public void run() {
        try{
            s.acquire();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        while (true) {
            synchronized (monitor) {
                try {
                    if (isPing) {
                        System.out.println("Ping");
                    } else {
                        System.out.println("Pong");
                    }
                    monitor.notify();
                    Thread.sleep(1000);
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new PingPong(true).start();
        new PingPong(false).start();
        new PingPong(false).start();
        new PingPong(false).start();
        new PingPong(false).start();

    }
}
