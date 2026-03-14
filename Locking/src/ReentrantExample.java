import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
//        lock.lockInterruptibly(); //this will allow to interrupt lock
        try{
            System.out.println("outer method");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void  innerMethod(){
        //this is again trying to lock, so inner method is dependent on outer class to complete and outer is waiting for inner to complete
        //to solve this issue we have ReentrantLock class, so same thread can access all locks and we have count of lock and unlock, after matching that count next thread can access, till then our main will be continue to proceed
        //example, if we have home key, then we can access all room of home, when we go out of the one of the room then and then out of the home then 0only new thread can be entered
        lock.lock();
        try {
            System.out.println("Inner method");
        }finally {
            lock.unlock();
        }
    }

    static void main() {
        ReentrantExample exmaple = new ReentrantExample();
        exmaple.outerMethod();
    }
}
