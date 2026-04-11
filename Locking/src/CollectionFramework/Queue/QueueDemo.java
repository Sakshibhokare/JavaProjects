package CollectionFramework.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

//A data structure that works on the FIFO principle
//Elements are added at the end and removed from the front
public class QueueDemo {
    static void main() {
        //linked list can act as a queue
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1); //adding called as enqueue
        list.addLast(2); // enqueue
        list.addLast(3); // enqueue
        System.out.println(list);
        Integer i = list.removeFirst(); //dequeue
        System.out.println(list);
        list.getFirst(); //peek

//        to reduce the complexity java reduced Queue
        // Queue is a interface and its implementation classes are LinkedList priority queue
        // for enqueue we have two methods --> add, offer
        // dequeue --> remove, poll
        // peek --> peek, element
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.size());
        System.out.println("remove " + queue.remove()); //throw axception
        System.out.println("poll " + list.poll());
        System.out.println(queue);

        System.out.println("peek " +  queue.peek());
        System.out.println("Element " + queue.element());

        //size is fixed here
        Queue<Integer> queue1 = new ArrayBlockingQueue<>(2);
        queue1.add(1);
        queue1.add(2);
//        queue1.add(3);
        System.out.println( queue1.offer(3)); //this will return true or false

    }
}
