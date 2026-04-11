package CollectionFramework.Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    static void main() {
        // double ended queue
        // allows insertion and removal of elements from both ends
        // versatile than regular queues and stacks because they support all the operations of both

        /*
        Insertion methods
        addFirst(E e): Inserts the specified element at the front
        addLast(E e): Insert the specified element at the end
        offerFirst(E e): Inserts the specified element at the front if possible
        offerLast(E e): Insert the specified element at the end if possible

        Examination methods
        getFirst(): Retrieves, but does not remove, the first element
        getLast(): Retrieves, but does not remove the last element
        peekFirst(): Retrieves, but does not remove the first element ot return null if empty
        peekLast(): Retrieves, but does not remove the last element or returns null if empty

        * */

        Deque<Integer> deque = new ArrayDeque<>();// recommended to use, less memory, continuous memory
        //array is circular so no need to shift elements at removal and addition, playing with indexes
        //just shift head and tail
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25);
        //5, 10, 20, 25
        System.out.println(deque);
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());
        deque.removeFirst();
        deque.pollLast();
        System.out.println(deque);


        Deque<Integer> deque1 = new LinkedList<>();// use this when insertion and deletions needs to be happen in middle, will play with pointers, we need to shift elements here
        //everything is same in case of Linked list, then why ArrayDeque,
        // ArrayDeque is faster iteration, low memory, no null allowed,
        // only in case of any specific requirement use linked list

    }
}
