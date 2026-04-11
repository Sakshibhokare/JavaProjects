package CollectionFramework.MapSortedMap;
//Navigable map extends sorted map, providing more powerful navigation options such as finding the closest matching key or retrieving thr map in reverse order.

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    static void main() {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(5, "Five");
        navigableMap.put(1, "One");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(4)); //Returns the greatest key strictly less than the given key
        System.out.println(navigableMap.ceilingKey(4)); //Returns the least key greater than or equal to the given key
    }
}
