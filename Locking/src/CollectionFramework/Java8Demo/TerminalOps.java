package CollectionFramework.Java8Demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    static void main() {
        List<Integer> list = Arrays.asList(1,2,3);

        // 1. collect interm ops   terminal ops
          list.stream().skip(1).collect(Collectors.toList());

          //2. for each
        list.stream().forEach(x-> System.out.println(x));

        //3. reduce: combines elements to produce a single result
        list.stream().reduce((x, y)->x+y);
        System.out.println("Sum: " +list.stream().reduce(Integer::sum));

        //4. count


        //5. anyMatch, allMatch, noneMatch

        boolean isEvenPresent = list.stream().anyMatch(x->x%2==0);
        boolean isAllEven = list.stream().allMatch(x->x%2==0);
        boolean isNoneMatch = list.stream().noneMatch(x->x<0);

        System.out.println("isEven: " + isEvenPresent + " All even: " + isAllEven + " none of them <0 " + isNoneMatch);

        //6. findFirst, findAny
        System.out.println("first" + list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        //7. toArray(): casting issue needs to be checked again
//        Objects[] array = (Objects[]) Stream.of(1,2,3,4).toArray();

        //8. min max
        System.out.println("max"+ Stream.of(2,44,69).max(Comparator.naturalOrder()).get()); // comes in optional[] so need to get
        System.out.println("min"+ Stream.of(2,44,69).min(Comparator.naturalOrder()).get());

        //9. forEachOrdered, streams are parallel but still order is maintained using for each ordered
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("Using for each with parallel stream: ");
        numbers2.parallelStream().forEach(System.out::println);
        System.out.println("Using for each ordered with parallel stream: ");
        numbers2.parallelStream().forEachOrdered(System.out::println);

        //Example
        List<String> names = Arrays.asList("Anna", "Bob", "CharLie", "David");
        System.out.println(names.stream().filter(x->x.length()>3).toList());

        //Example: Squaring and sorting Numbers
        List<Integer> numbers = Arrays.asList(5,6,7,8,3,6);
        System.out.println(numbers.stream().map(x->x*x).sorted().toList());

        //Example:Summing values
        List<Integer> integers = Arrays.asList(1,3,4,7,5,7,2,8);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        //Example: Counting Occurrence of a Character
        String sentence = "hello world";
        char[] charArray=sentence.toCharArray();// no need to do this
        long z = sentence.chars().filter(x->x=='l').count(); //for char will use chars

        //stateful and stateless operations
        //stateful: if a operation known about all elements like sorting
        //stateless: if operation know one element at one time like map

        //Example
        //Stream cannot be resued after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
//        stream.map(String::toUpperCase).toList();
    }
}
