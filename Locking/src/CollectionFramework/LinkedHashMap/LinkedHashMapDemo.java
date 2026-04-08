package CollectionFramework.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//this is also not thread safe
public class LinkedHashMapDemo {
    static void main() {
        //sub class of hashmap
        //the difference is this maintains the order, little slower than hashmap due to dll
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 03f, true); //double linked list
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 13);
        linkedHashMap.get("Apple"); // if the access order is true, then the recently accessed element will be in the last
        linkedHashMap.get("Orange"); // least recently used things will be on top, so we can remove that
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap); // pass in constructor, to convert hashmap to linked hashmap

        hashMap.put("Sham", 91);
        hashMap.put("Ram", 88);
        hashMap.put("Ghansham", 78);

        Integer res = hashMap.getOrDefault("Sham", 0); //if sham present then return it's key else return 0
        Integer res2= hashMap.getOrDefault("vipul", 0);
        System.out.println(res);
        System.out.println("vipul: " + res2);

        hashMap.putIfAbsent("Shubham", 92);
        hashMap.putIfAbsent("Sham", 66);
        System.out.println(hashMap);
    }
}
// caching: will remove least recently used element
