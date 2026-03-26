package ExecutorsFramework;

import java.util.concurrent.*;

// CyclicBarrier Example
// -------------------------------------------
// Key Idea:
// All threads wait for each other at a common point (barrier),
// and once all reach, they proceed together.
//
// Difference from CountDownLatch:
// - CountDownLatch → one-time use, main thread waits
// - CyclicBarrier → reusable, threads wait for each other
// -------------------------------------------

public class Main8 {

    // ✅ Proper main method
    public static void main(String[] args) throws InterruptedException {

        int numberOfServices = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

        // Barrier action → runs once ALL threads reach the barrier
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices, () -> {
            System.out.println("✅ All services reached barrier. Barrier action executed!");
        });

        // Submitting tasks
        executorService.submit(new BarrierService(barrier));
        executorService.submit(new BarrierService(barrier));
        executorService.submit(new BarrierService(barrier));

        System.out.println("Main"); //cyclic barrier dos not make main method wait
        executorService.shutdown();
    }
}

class BarrierService implements Runnable {

    private final CyclicBarrier barrier;

    public BarrierService(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " ➝ service started");

            // Simulate some work
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " ➝ waiting at barrier");

            // 🔥 CORE LOGIC:
            // Thread will STOP here until all threads reach this line
            barrier.await();

            // Once all threads reach barrier:
            // - Barrier action runs (once)
            // - All threads resume execution together
            System.out.println(Thread.currentThread().getName() + " ➝ passed barrier");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
//| Feature    | CountDownLatch                              | CyclicBarrier               |
//        | ---------- | ------------------------------------------- | --------------------------- |
//        | Usage      | One-time                                    | Reusable (cyclic)           |
//        | Who waits? | Main thread (or any thread calling `await`) | All worker threads          |
//        | Reset?     | ❌ No                                        | ✅ Yes                       |
//        | Direction  | Workers → notify main                       | Workers wait for each other |
//        | Method     | `countDown()`                               | `await()`                   |
//        | Use case   | Wait for tasks to finish                    | Synchronize phases          |

//🔥 When to Use What?
//Use CountDownLatch when:
//Main thread needs to wait
//Tasks are independent
//One-time event

//Use CyclicBarrier when:
//Threads must sync at checkpoints
//Multi-phase processing
//Reusable synchronization

//⚡ Bonus Insight
//CyclicBarrier is useful in problems like:
//Parallel computations
//Game engines (wait for all players)
//Simulation steps (phase-based execution)