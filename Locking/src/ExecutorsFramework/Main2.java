package ExecutorsFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {
    static void main() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //will use executors threadpool
        ExecutorService executor= Executors.newFixedThreadPool(9);
        for(int i=1; i<10; i++){
            int finalI = i;
            executor.submit(()->{ //when we are returning something this automatically call to callable, else call runnable
                long result = 0;
                try {
                    result = factorial(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(result);
            });
        }
        executor.shutdown();
        //here we are adding time of 100 sec, if not completed in 100 second then go ahead
        executor.awaitTermination(100, TimeUnit.SECONDS);
        //make unlimited wait
//        while(!executor.awaitTermination(10, TimeUnit.MILLISECONDS)){
//            System.out.println("waiting....");
//        }
        //this will get executed even if the thread execution is not completed in main
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) throws InterruptedException {
        Thread.sleep(1000);
        long result =1;
        for(int i=1; i<=n; i++){
            result*=i;
        }
        return result;
    }
}
