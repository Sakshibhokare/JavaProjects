package CollectionFramework.Java8Demo;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {
    static void main() {
        int[] numbers = {1,2,3,4,5,6}; //if we are using primitive data types then we have to use primitive streams
        IntStream stream = Arrays.stream(numbers);
        stream.boxed();
        System.out.println(IntStream.range(1, 5));
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        IntStream.of(1,2,4,5,6);
        DoubleStream doubles = new Random().doubles(5);
        System.out.println(doubles.boxed().toList());

        IntStream intStream = new Random().ints(5);
        System.out.println(intStream.boxed().toList());

//        doubles.mapToInt(x->x+1)
    }
}
