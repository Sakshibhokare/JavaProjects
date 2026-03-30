package CollectionFramework.Stack;

import java.util.LinkedList;
import java.util.Stack;
//stack extends Vector class
//if you want LIFO behaviour in less time complexity you can use Stack
// Inheritance: subclass of vector, which means all features of dynamic array but is constrained by the stack's LIFO nature
//stack is also synchronized, we should use only for multithreading scenario, for single threaded we can use LinkedList
public class StackDemo {
    static void main() {
        Stack<Integer>st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(0);
        st.push(5);
        st.push(60);
        st.push(40);
        System.out.println("stack: " + st);
        int removedElement = st.pop();
        System.out.println("removed: " + removedElement);
        System.out.println(st);

        int topElement = st.peek();
        System.out.println("Top element: " + topElement);

        //since this is extending to vector, we can add element in middle anywhere
        st.add(2, 80);
        System.out.println("2->80"+st);
        st.remove(3);
        System.out.println("removed 0:" +st);
        int searchIndex =st.search(2); //search is not 0 based
        System.out.println("search 2 index from top: "+searchIndex);

        //we can use LinkedList as stack also ArrayList
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(5); //push
        ll.getLast(); //peek
        ll.removeLast(); //pop


    }
}
