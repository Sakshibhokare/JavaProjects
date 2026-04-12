package CollectionFramework.Java8Demo;
//after Java8demo

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    static void main() {
        //feature introduced in java 8
        // with the help of stream we can process collection of data in a functional amd declarative manner
        //when stream was not there we used to do with loop, if else statements, due to this readability decreases and error changes increases
        //Enable easy parallelism without multithreading

//        what is stream
        // a sequence of elements supporting various operations(functional and declarative programming)

        //How to use Stream?
        //source -->converts-->, intermediate operations, terminal operations

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//        Stream<Integer> stream = numbers.stream();
        //find even number using stream            intermediate op                 terminal op
        int count = Math.toIntExact(numbers.stream().filter(x -> x % 2 == 0).count());
        System.out.println(count);

        //Creating Streams
        //1. From Collections
        List<Integer> list = Arrays.asList(1,2,3,4,56,7);
        Stream<Integer> stream = list.stream();

        //2. from arrays
        String[]array = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);

        //3. direct method: using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");

        //4. Infinite Streams
        Stream<Integer> generate = Stream.generate(()->1).limit(100);

        List<Integer> collect = Stream.iterate(1, x->x+1).limit(100).toList();
        System.out.println(collect);


    }
}
