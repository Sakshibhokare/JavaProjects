import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//here threads are accessing randomly, without the order, which is unfair
public class UnfairLockExample {
    private final Lock lock = new ReentrantLock();

    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " aquired the lock");
            Thread.sleep(3000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }
    }
    static void main() {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
