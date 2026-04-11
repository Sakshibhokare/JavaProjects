package CollectionFramework.MapSortedMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {
    static void main() {
        Map<Day, String> map = new HashMap<>();
//        EnumMap: if all keys in a map are values from a single enum, it is recommended to use an enumMap as the specific implementation. an EnumMap, which has the advantage of knowing all possibke keys in advance, is more efficient compare to other implementation, as it can used simple array as its underlying data structure
        Map<Day, String> map2 = new EnumMap<>(Day.class); //this will keep all values of enum
        map2.put(Day.THUSRDAY, "Gym");
        map2.put(Day.MONDAY, "walk");
        System.out.println("index of thursday:"+Day.THUSRDAY.ordinal());
        // so now hashing is require because we have ordinal index of enum
//      this also defins the order of enum
        System.out.println(map2);

        //array of size same as enum
        // [_,"Gym"_,_,_,_]
        //no hashing
        //ordinal/index is used
        //Faster than hashmap
        // memory efficient
    }
}

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THUSRDAY, FRIDAY, SATURDAY, SUNDAY
}