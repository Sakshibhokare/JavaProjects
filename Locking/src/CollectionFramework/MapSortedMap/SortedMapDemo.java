package CollectionFramework.MapSortedMap;

import java.util.SortedMap;
import java.util.TreeMap;
//Sorted map -> TreeMap -> Navigable Map, TreeMap is a implementation, Navigable map extends sorted map, sorted map and navigable maps are interfaces
//SortedMap is an interface that extends map and guarantees that the entries are sorted based on the keys, either in their natural ordering or by a specified Comparator.
public class SortedMapDemo {
    static void main() {
        //interface/class                    //implementation class
        SortedMap<String, Integer> map = new TreeMap<>();
        SortedMap<Integer, String> map2 = new TreeMap<>((a,b)-> b - a);
//        vvv Imp: Treemap: is a Red black tree: self balancing binary search tree
        map.put("Bibek", 91);
        map.put("Alina", 80);
        map.put("Sakshi", 99);
        map.put("Pranay", 70);
        System.out.println("map: " + map); //ascending order based on keys
        System.out.println("first key: " + map.firstKey());
        System.out.println("lastKey: " + map.lastKey());
        System.out.println("head map: " + map.headMap("Bibek")); //not includes head, till head returns
        System.out.println("tail map: " + map.tailMap("Pranay"));

        System.out.println("start to end: " + map.subMap("Bibek", "Sakshi")); //exclude head

        map2.put(9, "sakshi");
        map2.put(89, "Pranay");
        map2.put(2, "sham");
        System.out.println(map2);
    }
}
