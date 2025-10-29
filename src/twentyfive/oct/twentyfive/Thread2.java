package twentyfive.oct.twentyfive;

public class Thread2 {

    private static Object lock = new Object();
    private static int number = 0;
    private static int max = 10;


    public static void main(String[] args) throws InterruptedException {

        Thread first = new Thread(() -> {

            while (number <= max) {

                synchronized (lock) {
                    if (number % 2 == 1) {
                        System.out.println("odd number " + number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {


                        }

                    }
                }

            }

        });


        Thread second = new Thread(() -> {

            while (number <= max) {

                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println("even number " + number);
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {


                        }

                    }
                }

            }

        });

        first.start();
        second.start();
        first.join();
        second.join();

    }


}
