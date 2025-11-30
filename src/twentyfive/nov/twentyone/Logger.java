package twentyfive.nov.twentyone;

import java.util.concurrent.*;

public class Logger {

    private static int counter = 0;
    public static void main(String[] args) {


        int maxNumber = 100;
        Object lock = new Object();

        for (int i = 0; i <2; i++) {
            int id = i;
            new Thread(() -> {
                while (counter < maxNumber) {
                    synchronized (lock) {
                        if (counter % 2 == id) {
                            System.out.println(counter + "from id " + id);
                            counter++;
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        lock.notifyAll();
                    }
                }

            }).start();
        }



    }



}
