package CollectionFramework.LinkedList;
//here is not contiguous memory
//we always store two thing, value and pointer
//we have doubly linked list as well
//circular Linked list

//performance consideration: insertion and deletion is easy
// LinkedList has slower random access compared to Arraylist
// Memory overhead: LinkedList requires more memory than ArrayList because each node in LL requires extra memory to store references
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static void main() {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.value=1;
        node1.next=node2;
        node2.value = 3;
        node2.next = null;

        //in java we do not need to write this manually
        LinkedList<Integer> LL = new LinkedList<>(); //we can also get reference of parent List
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.get(2);//O(n)
        LL.addLast(4);//O(1)
        LL.addFirst(0);//O(1)
        LL.getFirst();
        LL.getLast();
        System.out.println("LL " +LL);
        LL.remove(2);
        LL.removeFirst();
        System.out.println("remove first and last " +LL);
        LL.removeIf(x->x%2==0);
        System.out.println(LL);

        //on the fly LL
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("cat", "dog", "elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("dog"));
        animals.removeAll(animalsToRemove); //this is also work for arrayList
        System.out.println(animals);


    }
}

class Node{
    public int value;
    public Node next;
}
