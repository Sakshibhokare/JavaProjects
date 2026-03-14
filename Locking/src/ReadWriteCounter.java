import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;

    // ReadWriteLock implementation
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    /*
     * Read Lock:
     * Multiple threads can hold the read lock simultaneously
     * as long as no thread holds the write lock.
     */
    public int getCount() {
        lock.readLock().lock();   // acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() + " reading value: " + count);
            return count;
        } finally {
            lock.readLock().unlock(); // always release lock
        }
    }

    /*
     * Write Lock:
     * Only one thread can modify the resource at a time.
     * While writing, no other read or write is allowed.
     */
    public void increment() {
        lock.writeLock().lock(); // acquire write lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented value to: " + count);
        } finally {
            lock.writeLock().unlock(); // release write lock
        }
    }

    static void main() {
        ReadWriteCounter counter = new ReadWriteCounter();

        // Writer Thread
        Runnable writer = () -> {
            for(int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Reader Thread
        Runnable reader = () -> {
            for(int i = 0; i < 5; i++) {
                counter.getCount();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Creating threads
        Thread writer1 = new Thread(writer, "Writer-1");

        Thread reader1 = new Thread(reader, "Reader-1");
        Thread reader2 = new Thread(reader, "Reader-2");
        Thread reader3 = new Thread(reader, "Reader-3");

        writer1.start();
        reader1.start();
        reader2.start();
        reader3.start();
    }
}

