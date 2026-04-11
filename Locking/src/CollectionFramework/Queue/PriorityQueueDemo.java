package CollectionFramework.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    static void main() {
        //part of the queue interface
        //Orders elements based on their natural ordering (for primitives lowest firts)
        //custom comparator for customised ordering
        //the first element will have the highest priority and does not allow null elements
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((x, y) -> y - x);

        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5); //lowest value elements will have highest priority
        System.out.println("First element: " + pq.peek());
        pq.remove();
        System.out.println("Second priority: " + pq.peek());

        //not sorted, we are not concern about the internal, we want the peek element
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        System.out.println(pq);

        //internal working
        //PriorityQueue is implemented as a min-heap by default (for natural ordering)
        //min heap: every node value will be smaller than their children, smallerst elemnt will be root
        //insert TC --> O(long n), top --> O(1) , remove --> O(log n) :: mean heap


    }
}
