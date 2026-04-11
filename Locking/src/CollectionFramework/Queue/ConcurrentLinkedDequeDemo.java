package CollectionFramework.Queue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {

    public static void main(String[] args) throws InterruptedException {

        /*
         * ============================================================
         * 🔹 WHAT IS ConcurrentLinkedDeque?
         * ============================================================
         * - A thread-safe, non-blocking, double-ended queue (Deque)
         * - Part of java.util.concurrent package
         * - Uses CAS (Compare-And-Swap) → no locks → high performance
         *
         * 👉 "Concurrent" = safe for multiple threads
         * 👉 "Linked" = internally uses linked nodes
         * 👉 "Deque" = can add/remove from BOTH ends
         *
         * ============================================================
         * 🔹 KEY FEATURES
         * ============================================================
         * ✅ Non-blocking (no thread will wait)
         * ✅ Thread-safe without locks
         * ✅ High throughput in concurrent systems
         * ❌ No blocking methods like take(), put()
         * ❌ poll() returns null if empty (no waiting)
         */

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();


        /*
         * ============================================================
         * 🔹 BASIC OPERATIONS
         * ============================================================
         */

        // Add elements at the tail (end)
        deque.add("Task-1");
        deque.addLast("Task-2");

        // Add elements at the head (front)
        deque.addFirst("Task-0");

        System.out.println("Initial Deque: " + deque);


        /*
         * ============================================================
         * 🔹 MULTI-THREADING EXAMPLE
         * ============================================================
         * We simulate:
         * - Multiple producers adding tasks
         * - Multiple consumers processing tasks
         */


        // 🔹 Producer Thread (adds elements from BOTH ends)
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                deque.addFirst("Producer-Front-" + i);
                deque.addLast("Producer-Back-" + i);

                System.out.println("Produced: " + i);

                try {
                    Thread.sleep(200); // simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // best practice
                }
            }
        });


        // 🔹 Consumer Thread (removes elements from BOTH ends)
        Thread consumer = new Thread(() -> {
            while (true) {

                // Remove from front
                String front = deque.pollFirst();

                // Remove from back
                String back = deque.pollLast();

                if (front != null)
                    System.out.println("Consumed from FRONT: " + front);

                if (back != null)
                    System.out.println("Consumed from BACK: " + back);

                /*
                 * ⚠️ IMPORTANT:
                 * Since it's NON-BLOCKING:
                 * - If deque is empty → poll() returns null
                 * - So we must handle null manually
                 */

                try {
                    Thread.sleep(300); // simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });


        producer.start();
        consumer.start();

        /*
         * ============================================================
         * 🔹 LET THREADS RUN FOR SOME TIME
         * ============================================================
         */
        Thread.sleep(3000);

        /*
         * ============================================================
         * 🔹 INTERRUPT THREADS (GRACEFUL SHUTDOWN)
         * ============================================================
         */
        producer.interrupt();
        consumer.interrupt();

        producer.join();
        consumer.join();


        /*
         * ============================================================
         * 🔹 FINAL STATE
         * ============================================================
         */
        System.out.println("Final Deque: " + deque);


        /*
         * ============================================================
         * 🔹 REAL-WORLD USE CASES
         * ============================================================
         *
         * 1. Work Stealing Algorithms
         *    - Threads take tasks from front
         *    - Idle threads steal from back
         *
         * 2. Task Scheduling Systems
         *    - High-priority → addFirst()
         *    - Low-priority → addLast()
         *
         * 3. Undo/Redo Systems
         *    - addFirst() for latest operations
         *
         * 4. Event Processing Pipelines
         *    - Multiple producers + multiple consumers
         *
         * 5. Caching / Buffer Systems
         *    - Remove oldest or newest dynamically
         */


        /*
         * ============================================================
         * 🔥 IMPORTANT DIFFERENCES TO REMEMBER
         * ============================================================
         *
         * ConcurrentLinkedDeque vs BlockingDeque (LinkedBlockingDeque)
         *
         * Feature              | ConcurrentLinkedDeque | BlockingDeque
         * -------------------------------------------------------------
         * Blocking            | ❌ No                 | ✅ Yes
         * Thread-safe         | ✅ Yes                | ✅ Yes
         * Performance         | 🚀 High               | Medium (locks)
         * Empty behavior      | returns null          | waits
         * Use case            | high concurrency      | producer-consumer
         *
         */


        /*
         * ============================================================
         * ⚠️ COMMON INTERVIEW PITFALLS
         * ============================================================
         *
         * ❌ Mistake: Expecting poll() to wait
         *     → It NEVER waits
         *
         * ❌ Mistake: Ignoring null
         *     → Always check result of poll()
         *
         * ❌ Mistake: Using it for producer-consumer blocking scenario
         *     → Use BlockingQueue instead
         *
         */


        /*
         * ============================================================
         * 🧠 FINAL TAKEAWAY
         * ============================================================
         *
         * Use ConcurrentLinkedDeque when:
         * - You need HIGH PERFORMANCE
         * - You DON'T want threads to block
         * - You can handle empty cases manually
         *
         * Use BlockingQueue when:
         * - You want automatic waiting (producer-consumer)
         *
         */
    }
}
