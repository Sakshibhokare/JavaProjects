package CollectionFramework.WeakHashMap;

import java.util.HashMap;
import java.util.Map;
//3:15
public class IdentityHashMapDemo {
    static void main() {
        String key1 = new String("key");
        String key2 = new String("key");
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(map);
    }
}
