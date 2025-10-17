package twentyfive.oct.seventeenth;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread1 {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new ChildThread();
        thread.start();

        Thread t2 = new Thread(() -> System.out.println("lambda therad"));
        t2.start();

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(() -> System.out.println("executor thread using lambda"));
        Thread.sleep(100);


    }


    static class ChildThread extends Thread {
        public void run() {
            System.out.println("child thread running");
        }
    }
}


