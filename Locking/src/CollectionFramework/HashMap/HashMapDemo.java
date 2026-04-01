package CollectionFramework.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// check Map before this

//key characteristics
//Unordered: Does not maintain any order of its elements
//Allows null keys and Values: we can have one null key and multiple null values
//Not Synchronized: Not thread safe
//Performance: Offers constant time performance (O(1)) for basic operations like get and put, assuming the hash function disperses elements properly

public class HashMapDemo {
    static void main() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31,"Shubham");
        map.put(11, "Akshit");
        map.put(2, "Neha");
//        map.put(null, "Vipul"); //we can only have one null key, if we have multiple this will overwrite
        System.out.println(map);

        String student = map.get(2);
        System.out.println(student);

        System.out.println("is Shubham present?: " + map.containsValue("Shubham"));

//        Set<Integer> keys = map.keySet();
//        for(int i: keys){ //this will throw null pointer exception we will have to handle that
          for (int i: map.keySet()){ //we do this
            System.out.println(map.get(i));
        }

//          Set<Map.Entry<Integer, String>> entries = map.entrySet();
          for(Map.Entry<Integer, String> entry:map.entrySet()){
              System.out.println(entry.getKey()+ " : "+entry.getValue().toUpperCase());
          }

          map.remove(31);
         System.out.println(map);
    }
}
