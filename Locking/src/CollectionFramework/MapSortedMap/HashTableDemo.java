package CollectionFramework.MapSortedMap;

import java.util.Hashtable;

public class HashTableDemo {
    static void main() {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        //Hashtable is synchronized, thread safe
        //no null key or value
        //legacy class, ConcurrentHashMap
        //slower than hashmap, not used much
        //only linked list in case of collision
        hashtable.put(1, "Apple");
        hashtable.put(2, "banana");
        System.out.println(hashtable);
        System.out.println("value for key 2: "+ hashtable.get(2));
        System.out.println(hashtable.containsKey(3));

        //all methods are synchronize, including get, so only for reading we use to wait, so we introduce ConcurrentHashMap
        Hashtable<Integer, String> map = new Hashtable<>();
        Thread thread1 = new Thread(()->{
            for (int i=0; i<1000; i++){
                map.put(i, "thread1");
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i=1000; i<2000; i++){
                map.put(i, "thread2");
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final size of Hashtable: " + map.size());
    }
}
