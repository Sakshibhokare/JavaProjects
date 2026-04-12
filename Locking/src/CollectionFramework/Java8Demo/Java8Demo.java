package CollectionFramework.Java8Demo;

import java.util.function.Predicate;

public class Java8Demo {
    static void main() {
        //Streams
        //why java 8: --> minimal code, functional programing features introduced,
        //Java 8--> lambda expression, Streams, Data and Time Api

        //Lambda Expression: anonymous function, (no name, no return type, no access modifier)
        Thread t1 = new Thread(()->{
            System.out.println("Lambda Expression");
        });
        t1.start();
        //used to implement function interface
        //Functional Interface: interface with only one abstract method, abstract method which does not have body

        //lambda expression implements functional interfaces
        MathOperations sumOperation = ( a, b)-> a+b; //this is a functional programming
        MathOperations subtract = (a, b)-> a-b;
        System.out.println("Add: " + sumOperation.operate(5, 9) + " subtract: " +subtract.operate(9, 5) );


        // Predicate --> Functional Interface (Boolean valued function)
        //we are storing a condition in a variable,
        Predicate<Integer> isEven = x-> x%2==0;
        System.out.println( isEven.test(4));
        Predicate<String> isWordStartingWithLatterA = x -> x.startsWith("A");
        System.out.println(isWordStartingWithLatterA.test("Apple"));
    }
}
//class SumOperation implements MathOperations{
//
//    @Override
//    public int operate(int a, int b) {
//        return a+b;
//    }
//}
//annotation
@FunctionalInterface // this mean we restrict with only one function, can not have more than one
interface MathOperations{
    int operate(int a, int b);
}
