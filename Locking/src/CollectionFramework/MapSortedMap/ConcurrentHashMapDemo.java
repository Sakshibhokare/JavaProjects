package CollectionFramework.MapSortedMap;
//after hashtable
//all methods are synchronize in hashtable, including get, so only for reading we use to wait, so we introduce ConcurrentHashMap

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    static void main() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // java 7 --> segment based locking --> 16 segment --> smaller hashmaps
        // only the segment being written to or read from is locked
        // read: do not require locking unless there is a write operation happening on the same segment
        // write: lock

        // java 8 --> no segmentation(cause 16 was fixed, not scalable)
        // this uses --> compare and swap approach --> no locking except resizing or collision
        // thread A last saw --> x = 42
        // thread A work --> x to 50
        // if x still 42 then change to 50, else dont change and retry
        // retry chalta hei instead of locking, this retries after short random time, so that CPU doesnt get wasted
        // put --> index , will check if index is empty then put
        // update --> will check last saw value is same then update, retry

        // in collision we play with LL, so that particular bucket will be locked,
        // here incremental resizing happens, if you adding one bucket and another thread comes and tries to access, then we apply lock to that

        //a map who stored data in sorted manner and thread safe --> ConcurrentSkipListMap
        // Map --> Sorted --> Thread safe
    }
}
