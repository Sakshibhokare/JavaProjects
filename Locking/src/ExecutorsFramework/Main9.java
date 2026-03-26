package ExecutorsFramework;

import java.util.concurrent.*;
//introduce in java 8
// CompletableFuture Example
// ------------------------------------------------------------
// CompletableFuture is used for:
// 1. Asynchronous programming (non-blocking)
// 2. Chaining tasks
// 3. Combining multiple tasks
// 4. Handling results without blocking (like Future.get())
// ------------------------------------------------------------

public class Main9 {

    // ✅ Proper main method
    public static void main(String[] args) throws Exception {

        // Step 1: Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // ------------------------------------------------------------
        // supplyAsync() → runs a task asynchronously and RETURNS a result
        // ------------------------------------------------------------
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " → Fetching data...");
                Thread.sleep(2000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from DB";
        }, executor);

        // ------------------------------------------------------------
        // thenApply() → transforms the result (like map in streams)
        // Runs AFTER previous task completes
        // ------------------------------------------------------------
        CompletableFuture<String> processedFuture = future.thenApply(data -> {
            System.out.println("Processing: " + data);
            return data.toUpperCase();
        });

        // ------------------------------------------------------------
        // thenAccept() → consumes the result (no return)
        // ------------------------------------------------------------
        processedFuture.thenAccept(result -> {
            System.out.println("Final Result: " + result);
        });

        // ------------------------------------------------------------
        // thenRun() → runs after completion, but NO access to result
        // ------------------------------------------------------------
        processedFuture.thenRun(() -> {
            System.out.println("Task completed!");
        });

        // ------------------------------------------------------------
        // join() → waits for completion (like get() but no checked exception)
        // ------------------------------------------------------------
        processedFuture.join();

        executor.shutdown();
    }
}
//supplyAsync() → thenApply() → thenAccept() → thenRun()
//By default, CompletableFuture tasks often run on daemon threads due to the use of ForkJoinPool.commonPool
//You can control the thread type by providing a custom executor service.
//The CompletableFuture task itself doesn't dictate whether it's a daemon or user thread