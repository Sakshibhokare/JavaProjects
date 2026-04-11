package CollectionFramework.SetOverview;

import javax.xml.transform.Source;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

//Why this: Thread safe
//          Copy on write mechanism
//          No duplicate elements
//          Iterators Do not reflect modifications
public class CopyOnWriteArraySetDemo {
    static void main() {
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet= new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for(int i=1; i<=5; i++){
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }
        //evry write this creates new copy, so when write operations are less and read intensive then will use this
        System.out.println("Initial CopyOnriteArraySet: " + copyOnWriteArraySet);
        //frequent read and write will use below
        System.out.println("Initial ConcurrentSkipListSet: " + concurrentSkipListSet);

        System.out.println("Iterating and modifying CopyOnWriteArraySet");
        for (Integer num: copyOnWriteArraySet){
            System.out.println("Reading from CopyOnWriteArraySet: " + num);
            //Attempting to modify the set during iteration
            copyOnWriteArraySet.add(6); //this will not print this
        }

        //this is weakly consistent
        System.out.println("Iterating and modifying ConcurrentSkipListSet: ");
        for(Integer num: concurrentSkipListSet){
            System.out.println("Reading from ConcurrentSkipListSet: " + num);
            //Attempting to modify the set during iteration
            concurrentSkipListSet.add(6); //this will print
            if(num==6){
                concurrentSkipListSet.add(7); //if we are adding when printing the last element then will skip this one
            }
        }
    }
}
