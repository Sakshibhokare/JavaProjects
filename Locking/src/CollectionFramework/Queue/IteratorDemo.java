package CollectionFramework.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    static void main() {
        List<Integer> list = new ArrayList<>(); //we can add for each loop because arrayList implements iterator
        list.add(5);
        list.add(2);
        list.add(5);
        for(int i:list){
            System.out.println(i);
        }

        //internal working of iterable, methods are hasNext, next, remove
        //java compiler convert this code into the following code
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //using iterator we can remove element while iterating, if we does the same then exception will occur
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()){
            Integer number = itr.next();
            if(number%2==0){
                itr.remove();
            }
        }
        System.out.println(list);

        ListIterator<Integer>listIterator = list.listIterator();
        while (listIterator.hasNext()){
            listIterator.set(listIterator.next());
        }
    }
}
