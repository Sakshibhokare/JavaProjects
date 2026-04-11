package CollectionFramework.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    static void main() {
        //when producer sends message then only consumer receives till then waits, so sync happening
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(()->{
            try{
                System.out.println("Producer is waiting to transfer");
                Thread.sleep(3000);
                queue.put("Hello from producer!");
                System.out.println("Producer has transferred the message");
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Producer was interrupted.");
            }
        });

        Thread consumer = new Thread(()->{
            try{
                System.out.println("Consumer is waiting to receive");
                String message = queue.take();
                System.out.println("Consumer received: " + message);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Consumer was interrupted.");
            }
        });

        producer.start();
        consumer.start();

    }
}
