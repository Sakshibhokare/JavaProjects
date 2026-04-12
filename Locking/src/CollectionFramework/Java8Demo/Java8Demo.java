package CollectionFramework.Java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

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
        Predicate<String> isWordEndsWIthT = x->x.endsWith("T");
        System.out.println("A and T: " + isWordStartingWithLatterA.and(isWordEndsWIthT).test("AnkiT"));
        System.out.println(isWordStartingWithLatterA.test("Apple"));

        //Function --> work for you
        //Functions vs methods
        Function<Integer, Integer> doubleIt = x->2*x;
        System.out.println(doubleIt.apply(200));
        Function<Integer, Integer> tripleIt = x->3*x;
        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));
        Function<Integer, Integer> identity =  Function.identity();


        //Consumer
        Consumer<Integer> consumer = (x) ->System.out.println(x); // this only consumes, does not returns anything
        consumer.accept(51);
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> printlits = (x)-> System.out.println(x);
        printlits.accept(list);

        //Supplier
        Supplier<String> giveHelloWord = ()->"Hello World";
        System.out.println(giveHelloWord.get());

        //Combined example
        Predicate<Integer> predicate = x->x%2 == 0;
        Function<Integer, Integer> function = x -> x*x;
        Consumer<Integer> consumer1 = x-> System.out.println(x);
        Supplier<Integer> supplier = ()->100;

        if(predicate.test(supplier.get())){
            consumer1.accept(function.apply(supplier.get()));
        }

        //for taking two arguments
        //BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer, Integer> isSumEven= (x, y)->(x+y)%2==0;
        System.out.println(isSumEven.test(5,5));
        BiConsumer<Integer, String> biConsumer = (x,y)->{
            System.out.println("X " +x);
            System.out.println("Y " +y);
        };
        //         input   input   outputType
        BiFunction<String, String, Integer> biFunction = (x, y)->(x+y).length();
        System.out.println("ME and Him " + biFunction.apply("Sakshi", "Pranay"));
//              input output both integer
        UnaryOperator<Integer> a = x->2*x;
        BinaryOperator<Integer> b = (x, y)->x+y;


        //Method Reference --> use methods without invoking and in place of lambda expression
        List<String> students = Arrays.asList("Ram", "Shyam", "Ghansham");
        students.forEach(x-> System.out.println(x));
        students.forEach(System.out::println);

        //Constructor reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone>mobilePhones = names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
        List<MobilePhone>mobilePhones2 = names.stream().map(MobilePhone::new).toList();
        System.out.println(mobilePhones2);

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

class MobilePhone{
    String name;

    @Override
    public String toString() {
        return "MobilePhone{" +
                "name='" + name + '\'' +
                '}';
    }

    public MobilePhone(String name) {
        this.name = name;
    }
}


