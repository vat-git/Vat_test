package twentyfive.nov.sixteenth;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pools {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> submit = executorService.submit(() -> {
            return "test";
        });
        System.out.println(submit.get());
        executorService.shutdown();


        System.exit(0);
    }




}
