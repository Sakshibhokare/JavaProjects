package ExecutorsFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//Executors Methods
public class Main5 {
//    static void main() throws InterruptedException, ExecutionException {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        Callable<Integer> call1 = ()->{
//            Thread.sleep(1000);
//            System.out.println("task 1");
//            return  1;
//        };
//        Callable<Integer> call2 = ()->{
//            Thread.sleep(1000);
//            System.out.println("task 2");
//            return 2;
//        };
//        Callable<Integer> call3 = ()->{
//            Thread.sleep(1000);
//            System.out.println("task 3");
//            return 3;
//        };
//
//        List<Callable<Integer>> list = Arrays.asList(call1,call2,call3);
//       //invoke will block main method, till all tasks gets completed
//        //we can give time out as well so that invoke method will only wait till that time after that it will give time out error
//        for (Future<Integer> integerFuture : executor.invokeAll(list, 1, TimeUnit.SECONDS)) {
//            System.out.println(integerFuture.get());
//        }
//
//        executor.shutdown();
//        System.out.println("will get printed in last");
//}

    static void main() throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorService.submit(()->{
//            try{
//                Thread.sleep(2000);
//            }catch (InterruptedException e){
//                System.out.println("Exception ocurred");
//                return null;
//            }
//            System.out.println("hello");
//            return 42;
//        });
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("sleep");
//        }
//        System.out.println(future.get());
//        future.cancel(true); //if task is running then not interrupt
//        System.out.println(future.isCancelled());
//        System.out.println(future.isDone()); //task is complete or got exception
//        executorService.shutdown();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
                return null;
            }
            System.out.println("hello");
            return 42;
        });

        Thread.sleep(1000);

// Cancel while task is still running
        //task should be running till we come to cancel if it is executed already then we can not cancel that task
        boolean cancelled = future.cancel(true);
        System.out.println("Cancelled: " + cancelled);

        System.out.println("isCancelled: " + future.isCancelled());
        System.out.println("isDone: " + future.isDone());

        executorService.shutdown();
    }
}
