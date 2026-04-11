package CollectionFramework.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//ConcurrentLinkedQueueDemo
//compare and swap technique is used, linked list, head and tail
//An implementation of the queue interface that supports lock free thread safe operations
public class TaskSubmissionSystem {
    private static BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();
    static void main() {
// in case of blocking queue we can not perform put put together or put take together
//        but in ConcurrentLinkedQueue we can run them simultaneously
         Thread producer = new Thread(()->{
             while (true){
                 try{
                     taskQueue.put("Task " + System.currentTimeMillis());
                     System.out.println("inside producer");
                 }catch (InterruptedException e){
                     e.printStackTrace();
                 }
             }
         });
        Thread consumer = new Thread(()->{
            while (true){
                try{
                    String task = taskQueue.take();
                    System.out.println("Processing: " + task);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

    }
}

//🎯 When to Use What
//✅ Use BlockingQueue when:
//        You want automatic waiting
//        Producer-consumer model
//        Thread coordination required
//
//👉 Your current code = PERFECT use case
//
//        ✅ Use ConcurrentLinkedQueue when:
//        You want high performance
//        No blocking needed
//        You handle retries manually
