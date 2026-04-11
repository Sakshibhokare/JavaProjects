package CollectionFramework.WeakHashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
//3:15
public class IdentityHashMapDemo {
    static void main() {
        String key1 = new String("key"); //string hashcode plays with content
        String key2 = new String("key");
        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));

        System.out.println("String hashcode: " + key1.hashCode());
        System.out.println("String hashcode: " + key2.hashCode());
//        Map<String, Integer> map = new HashMap<>(); //uses hash code of String
        Map<String, Integer> map = new IdentityHashMap<>(); //uses it's object class's hashcode, which plays with memory address, since we used new String, memory address is different for both, so new string will be created
        //identity Hashcode and == even if the hashcode value is same will check address
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(map);
    }
}
