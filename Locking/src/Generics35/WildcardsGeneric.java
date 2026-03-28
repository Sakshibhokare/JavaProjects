package Generics35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsGeneric {
    static void main() {
     ArrayList<?> list = new ArrayList<>();// read only work, no return
        System.out.println(sum(Arrays.asList(1, 2, 3.5, 6)));


    }



    //when we are only doing read only work we can use wildcard pattern <?>
    public <T> T getFirst(ArrayList<T> list){
        return list.get(0);
    }

    //we are turning sum then that should be a number, double return type is always safer
    public static double sum(List<? extends Number> numbers){ //Number is upper bound
        double sum = 0;
        for(Number o: numbers){
            sum+=o.doubleValue();
        }
        return sum;
    }

    //we can use super keyword: this mean we are adding a ceiling, we cam use super classes on integer but not the sub classes
    public static void printNumber(List<? super Integer> list){
        for(Object obj:list){
            System.out.println(obj);
        }
    }
}

