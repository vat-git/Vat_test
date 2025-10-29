package twentyfive.oct.twentyfive;

public class Threads1 {


    public static void main(String[] args) throws InterruptedException {


        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("first Thread priting");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("second Thread priting");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


        firstThread.start();
        second.start();
        firstThread.join();
        second.join();


    }
}
