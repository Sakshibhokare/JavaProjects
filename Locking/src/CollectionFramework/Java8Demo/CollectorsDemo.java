package CollectionFramework.Java8Demo;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    static void main() {
        //Collectors is a utility class
        //provides a set of methods to create common collectors

        //1. Collecting to a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream().
                filter(name->name.startsWith("A")).
                collect(Collectors.toList());

        System.out.println(res);

        //2. Collecting to a set
        List<Integer> nums = Arrays.asList(1,2,3,4,4,4,5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println("Set " + set);

        //3. Collecting to a specific collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(()-> new ArrayDeque<>()));

        //4. Joining String
        // Concatenates stream elements into a single string
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(concatenatedNames);

        //5. Summarizing Data
        //Generates statistical summary (count, sum, min, average, max)
        List<Integer> numbers = Arrays.asList(2,3,4,5,7,11);
        IntSummaryStatistics stats =  numbers.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        //6. Calculating averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x->x));
        System.out.println("Direct Average: " + average);

        //7. count elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        //8. Grouping Elements
        List<String> words = Arrays.asList("Hello", "worlds", "Java", "Collecting");
        System.out.println( words.stream().collect(Collectors.groupingBy(x-> x.length()))); // grouping based on length
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(",")))); //after grouping, what actions you want to perform
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting())); //map sorted by key
        System.out.println(treeMap);

        //9. Partitioning Elements
        // Partitions elements into groups (true and false) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length() > 5)));

        //10. Mapping and Collecting
        //Applies a mapping function before collection
        System.out.println(words.stream().collect(Collectors.mapping(x->x.toUpperCase(), Collectors.toList())));

        //solve questions using chatgpt ask to provide questions

        //Example 1: Collecting names by length
        //we have done this before

        //Example 2: Counting words occurrences
        String sentence = "hello world java world ";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x, Collectors.counting())));

        //Example 3: Partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2 ==0)));

        //Example 4: Summing values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 6);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));

        //Example 5: Creating a map from stream Elements
        List<String>  fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x->x.toUpperCase(), x-> x.length())));

        //Example 6: use toMap, if things are repeating then we have to use second signature toMap
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "banana", "apple");
        System.out.println(words2.stream().collect(Collectors.toMap(k->k, v->1, (x,y)->x+y))); //using the merge function count will increase

    }
}
