package CollectionFramework.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    //whenever this becomes true this removes the oldest entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }

    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;


    }


    static void main() {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 45);
        studentMap.put("Ram", 45);
        studentMap.get("Bob");// now bob will stay and alice will be removed
        studentMap.put("Vipul", 56); //it removes entry at put method
//        studentMap.get("Bob"); bob is already removed
        System.out.println(studentMap);
    }
}
