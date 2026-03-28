package Generics35;

import java.util.ArrayList;

public class WildcardsGeneric {
    static void main() {
     ArrayList<?> list = new ArrayList<>();// read only work, no return
    }
    //when we are only doing read only work we can use wildcard pattern <?>
    public <T> T getFirst(ArrayList<T> list){
        return list.get(0);
    }
}

