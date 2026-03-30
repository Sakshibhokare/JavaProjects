package CollectionFramework.Vector;
//it was introduced in JDK 1.0 before collection framework and is synchronized making it thread safe.
//now it is a part of collection framework
//However due to its synchronization overhead, it's generally recommended to use other modern alternatives like Arraylist in single-threaded scenarios
//this mean it takes more time overhead, processing things, takes more memory so for single threaded scenarios it is recommended to use AL
// it is useful for multithreaded


import java.util.LinkedList;
import java.util.Vector;

//key feature
//Dynamic Array, Synchronized, Legacy Class, Resizing mechanism: when size exceeded, it doubles it size by default, allows random access
public class VectorDemo {
    static void main() {
        Vector<Integer> vector = new Vector<>(3, 5); // we can decide the increment, default is double
        System.out.println(vector.capacity());
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        System.out.println(vector.capacity());

        //pass collection to vector
        LinkedList<Integer> linkeList = new LinkedList<>();
        linkeList.add(1);
        Vector<Integer> vector1 = new Vector<>(linkeList);

        //same methods like arrayList, set, add, add with index and element, clear, isEmpty, set to replace

    }
}
