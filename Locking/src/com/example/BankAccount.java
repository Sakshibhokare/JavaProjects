package com.example;

//public class BankAccount {
//    private int balance =100;
//   //t2 will be waiting till t1 completes its execution including sleep time,
//    //sleep time is basically time taking to make updates in database
//    //we never know how much time it will take this will make t2 wait for infinite time if there is something went wrong since we have to added time out
//    //for solving this issue we will be using manual explicit loacking
//    public synchronized void withdraw(int amount){
//        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
//        if(balance>=amount){
//            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
//            try{
//                Thread.sleep(3000);
//            }catch(InterruptedException e){
//
//            }
//            balance-=amount;
//            System.out.println(Thread.currentThread().getName() + " completed withdrawal. remaining balance: " + balance);
//        }else{
//            System.out.println(Thread.currentThread().getName() + " insufficient balance");
//        }
//    }
//}

//disadvantages of synchronization
//fairnness
//Blocking: indefinite waiting
//Intertuptibility
//read write locking

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance =100;
    //lock is a interface we will create object of lock with implementation class
//    lock.lock() - if lock is not available for second thread, it will be awaiting, thread one will access after completion it will make unlock then similar will happen with thread 2


    //why reentrant:
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
        try {
            //if we are providing time here, this means, when new thread will come that thread will wait till given time to be accessible, if thread 1 not completes it execution in that given time then thread 2 will go ahead after waiting, in sync it was keep on waiting, here it is not, it will go ahead
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance>=amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + " Processing withdrawal " + amount) ;
                        Thread.sleep(3000); //we can get exception here as well
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " current remaining balance " + balance);
                    }catch(Exception e){
                        //never lose the information of interruption
                        Thread.currentThread().interrupt();
                    }finally {
                        //finally always gets executed, no matter what is the result but we always have to unlock the lock
                        lock.unlock();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + "Balance is insufficiant " + balance);
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try again later");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
