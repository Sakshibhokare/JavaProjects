package ExecutorsFramework;
import java.util.concurrent.*;

/*
INTERVIEW QUESTION:
What is the difference between Runnable and Callable in Java?

Runnable
--------
1. Introduced in Java 1.0
2. Method: run()
3. Does NOT return a result
4. Cannot throw checked exceptions
5. Used with Thread class

Callable
--------
1. Introduced in Java 1.5 (java.util.concurrent)
2. Method: call()
3. RETURNS a result
4. Can throw checked exceptions
5. Used with ExecutorService or FutureTask

Very common interview follow-up:
"When should we use Callable instead of Runnable?"

Answer:
When we want a task to return a value after completion.
Example: database query, API call, factorial calculation etc.
*/

public class Main3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
        ==========================
        Example 1: Runnable
        ==========================
        Runnable task performs work but cannot return result.
        */

        Runnable runnableTask = () -> {
            int sum = 0;
            for(int i = 1; i <= 5; i++){
                sum += i;
            }

            // Runnable cannot return result
            // So we must print it or store somewhere
            System.out.println("Runnable Sum = " + sum);
        };

        Thread t1 = new Thread(runnableTask);
        t1.start();
        t1.join(); // wait for thread to finish


        /*
        ==========================
        Example 2: Callable
        ==========================
        Callable can return a result.
        */

        Callable<Integer> callableTask = () -> {
            int sum = 0;

            for(int i = 1; i <= 5; i++){
                sum += i;
            }

            return sum; // Callable returns result
        };

        /*
        FutureTask acts as a bridge between Callable and Thread
        because Thread only accepts Runnable
        */

        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        Thread t2 = new Thread(futureTask);
        t2.start();

        // get() waits for computation and returns result
        int result = futureTask.get();

        System.out.println("Callable Sum = " + result);
    }
}

