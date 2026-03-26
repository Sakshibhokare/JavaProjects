package VolatileAndAtomic34;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileCounter {
//    without using lock, synchronize we can achieve isolation
//    java has given option for atomicity, like AtomicInteger, AtomicBoolean
//    private int counter = 0;
    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
//        counter++;
        counter.incrementAndGet();
    }
    public int getCounter(){
//        return counter;
        return counter.get();
    }
    static void main() throws InterruptedException {
        VolatileCounter vc = new VolatileCounter();
        Thread t1 = new Thread(()->{
            for (int i=0; i<1000; i++){
                vc.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0; i<1000; i++){
                vc.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("counter: " + vc.getCounter());
    }
}
//this is called atomicity
//OUTPUT: even after adding volatile, the problem is still there because multiple threads are using the same variable of main memory
//counter: 1715