package CollectionFramework.SetOverview;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    static void main() {
        // Set is a collection that cannot contain duplicate elements
//        Find and insert --> O(1)
        // faster operations
        // Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
        // Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> set = new LinkedHashSet<>(); // this is for ordered set, order of adding element
        Set<Integer> set = new TreeSet<>(); //for sorting
        Map<Integer, String> map = new HashMap<>();
         Set<Integer> integers= map.keySet(); //keys in map are set

        set.add(12);
        set.add(34);
        set.add(89);
        set.add(10);
        set.add(89);
        System.out.println(set);

//        we have NavigableSet as well , to get ceil and floor
        set.clear();
        System.out.println(set.isEmpty());


//        For thread safety, vv imp what to use and why not to use
        // all operation are blocked
        Set<Integer> integers1 = Collections.synchronizedSet(set);
        // instead of above method will use

        //ConcurrentSkipListSet
        Set<Integer> set1 = new ConcurrentSkipListSet<>();

        //Unmodifiable, we can add more than 10 entries here
        Set<Integer> integers2 = Set.of(1,2,3,4,5,6,7,8,9);

        // we can use SortedSet as well
    }
}
