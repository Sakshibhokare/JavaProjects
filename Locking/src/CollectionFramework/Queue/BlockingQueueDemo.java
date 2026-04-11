package CollectionFramework.Queue;

import java.util.concurrent.*;

class Producer implements Runnable{
    private BlockingQueue<Integer> quque;
    private int value =0;
    public Producer(BlockingQueue<Integer>queue){
        this.quque=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Producer produced: " + value);
                quque.put(value++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer Interrupted ");
            }

        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> quque;
    public Consumer(BlockingQueue<Integer>queue){
        this.quque=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer value = quque.take();
                System.out.println("Consumer Consumed: " + value);
                quque.put(value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer Interrupted ");
            }

        }
    }
}
public class BlockingQueueDemo {
    static void main() {
        //thread safe queue
        //wait for queue to become non empty/ wait for space
        //useful in multithreaded environment
        //simplify concurrency problem like producer-consumer
        //standard queue --> immediately performs operations
            // empty --> remove(no waiting)
            // full --> add(no waiting)
        //but wait is required the use blocking queue
        //put --> Blocks if the queue is full until space becomes available
        //take --> Blocks if the queue is empty until an element becomes available
        //offer --> Waits for space to become available, up to the specified timeout

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        //A bounded, blocking queue backed by circular array
        //low memory overhead
        //uses a single lock for both enqueue and dequeue operations
        // more threads --> problem
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        //optionally bounded backed by linked list
        //Uses two separate locks for enqueue and dequeue operations
        //higher concurrency between producer and consumer
        //this is useful when we have more threads
        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>(100); //if capacity given the size is fixed if not given then INTEGER.max

//        Creates a PriorityBlockingQueue with the default initial capacity (11) that orders its elements according to their
        // Binary Heap as array and can grow dynamically
        //unbounded, so put wont block, space will be available always
        // Head is based on their natural ordering or a provided
        BlockingQueue<String> queue2= new PriorityBlockingQueue<>();
         queue2.add("apple");
         queue2.add("banana");
         queue2.add("Cherry");
        System.out.println(queue2);
        System.out.println("head " + queue2.peek());

//      each insert operation must wait for a corresponding remove operation by another thread and vice versa.
//        it cannot store elements, capacity of at most one element
        BlockingQueue<Integer> queue3 = new SynchronousQueue<>();



    }
}
