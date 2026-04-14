package CollectionFramework.Java8Demo;

import java.lang.reflect.Array;
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

        //7. peek: also consumes but this is intermediate
        //performs an action on each element as it is consumed
        Stream.iterate(1, x->x+1).skip(10).limit(50).peek(System.out::println).count();

        //8. flatMap
        //Handle streams of collections, lists, or arrays where each element is itself a collection
        //Flatten nested structure (e.g. lists within lists) so that they can be processed as a single sequence of elements
        //Transform and flatten elements at the same time
        List<List<String>> listOflist = Arrays.asList(
                Arrays.asList("Apple", "banana"),
                Arrays.asList("Orange", "kiwi")
        );
        System.out.println( listOflist.get(1).get(1));
        //convert to stream and using flat map convert to single stream
        System.out.println(listOflist.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences.
                stream().
                flatMap(sentence->Arrays.stream(sentence.split(" "))).
                map(String::toUpperCase).toList());


    }
}
