package CollectionFramework.MapSortedMap;

import java.util.concurrent.ConcurrentSkipListMap;

//after concurrentHashMap
//a map who stored data in sorted manner and thread safe --> ConcurrentSkipListMap
// Map --> Sorted --> Thread safe
public class ConcurrentSkipListMapDemo {
    static void main() {
        //skipList --> data stored in data structure named as SkipList
        // HashMap --> Array me store hota hei
        // TreeMap --> Red black Tree me hota hei
        // similarly, Concurrent SkipList Map --> thread safe three map --> stores data in SkipList
        // what is skip list: probabilistic data structure : that allows for efficient search, insertion, and deletion operations.
        // it is similar to a sorted linked list but with multiple layers that skip over portions of the list to provide faster access to elements
        // sorted --> layers --> fast access
        // for example
        // layer 3 : 1 .. 5.. 9
        // layer 2 : 1..3..5..7..9
        // layer 1 : 1 2 3 4 5 6 7 8 9
        // search will start from layer 3, if finding to go to 1 first then to 5 five is greater then go to the next layer, and so on
        // why red black tree not used: binary search tree requires complex algorithms, which is not required here, here is not strictness we can do things randomly, with probability

        // we can use this in multi threaded case
//            implements ConcurrentNavigableMap
//        ConcurrentNavigableMap implements ConcurrentMap and NavigableMap
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();

    }
}
