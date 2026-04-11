package CollectionFramework.MapSortedMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    static void main() {
        // a map which is once created we can not remove, add, update

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);

        //in map1 we can make changes but in map2 we can not perform any action

        System.out.println("Map2: " + map2);
//        map2.put("D", 3) throws exception;

        // clean way to create map, instead of creating two maps
        Map<String, Integer> map3 = Map.of("Sham: ", 8, "Ghansham: ", 9);
        System.out.println("Map3: " + map3); // we can not modify this map
        // but it has limitation of 10 key value pairs
        // if want to add more then use Map.ofEntries()
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("A", 78), Map.entry("B", 90));
        System.out.println("Map4: " + map4);

    }
}
