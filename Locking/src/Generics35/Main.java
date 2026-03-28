package Generics35;

import java.util.ArrayList;

//introduce in java 5
//what was the problem, why generic introduce?
//before generics, when we were using ArrayList() there were no type safety, also manual casting was require, No compile time checking
//so now we have ArrayList<String> list = new ArrayList<String>();
public class Main {
    static void main() {
        Box<Integer> box = new Box<Integer>(); //box class will be generic now
        box.setValue(1);
//        int i = (String) box.getValue() //now will get compile time errors;
        int i = (int) box.getValue();
        System.out.println(i);


        Pair<Integer,String> pair = new Pair<>(1, "sakshi");
        System.out.println(pair.getKey() + ":" + pair.getValue());
    }
}
