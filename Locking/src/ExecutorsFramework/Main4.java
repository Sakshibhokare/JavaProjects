package ExecutorsFramework;
//Executore and Future methods
//A Future represents the result of an asynchronous computation.
//When a task is submitted to ExecutorService, it returns a Future object.

//That object allows you to:
//check if task is finished
//get result later
//cancel task

//ExecutorService Example

//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Main4 {
//
//    public static void main(String[] args) {
//
//        // Create a thread pool with 3 threads
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//
//        // Runnable task (does not return result)
//        Runnable task = () -> {
//            System.out.println("Task executed by: " + Thread.currentThread().getName());
//        };
//
//        // Submit task to executor
//        executor.execute(task);
//
//        // Shutdown executor after tasks finish
//        executor.shutdown();
//    }
//}

//5. Future Example (Callable)

//If we want a result, we use Callable instead of Runnable.

//import java.util.concurrent.*;
//
//public class Main4 {
//
//    public static void main(String[] args) throws Exception {
//
//        // Create executor service
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        // Callable task (returns result)
//        Callable<Integer> task = () -> {
//
//            // Simulate long computation
//            Thread.sleep(4000);
//
//            return 10 + 20;
//        };
//
//        // Submit task → returns Future
//        Future<Integer> future = executor.submit(task);
//
//        System.out.println("Task submitted...");
//
//        // get() waits until result is available
//        Integer result = future.get();
//
//        System.out.println("Result = " + result);
//
//        executor.shutdown();
//    }
//}

//Cancel Future Example
import java.util.concurrent.*;

public class Main4 {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(5000);
            return "Finished";
        };

        Future<String> future = executor.submit(task);

        // Cancel the task
        boolean cancelled = future.cancel(true);

        System.out.println("Cancelled: " + cancelled);

        executor.shutdown();
    }
}