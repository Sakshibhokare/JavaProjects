package CollectionFramework.Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//after streamDemo
public class InterMediateOperations {
    static void main() {
        //Intermediate operations transform a stream into another stream
        //They are lazy, meaning they dont execute until a terminal operation is invoked.

        //1. Filter
        List<String> list = Arrays.asList("Akshit", "ram", "Shyam", "Avinoor");
        //                       filter is intermediate op   this is terminal op
        Stream<String> a = list.stream().filter(x->x.startsWith("A")).limit(10);
        //no filtering at this point,
        long count = list.stream().filter(x->x.startsWith("A")).count();

        //2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        //3. sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((p, s)-> p.length()-s.length());

        //4. Distinct
        long countDi = list.stream().filter(x->x.startsWith("A")).count();
        System.out.println("Duplicates Count: " + countDi);
        System.out.println(list.stream().filter(x->x.startsWith("A")).distinct().count());

        //5. limit
//        long count2 = Stream.iterate(1, x->x+1).count(); infinite
//        System.out.println(count2);
         Stream.iterate(1, x->x+1).limit(100);

         //6. Skip, starts with 11 to next 100
        System.out.println(Stream.iterate(1, x->x+1).skip(10).limit(100).count());
    }
}
