package CollectionFramework.Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    static void main() {
        List<String> names= Arrays.asList("Alice", "Bob", "Charlie", "David");
        // intermediate ops will never executed before terminal or without terminal ops
        Stream<String> stream = names.stream().filter(name->{
            System.out.println("Filtering: " + name);
            return name.length()>3;
        });
//      this will get executed first
        System.out.println("Before terminal operations");
//      once terminal ops hit
        List<String> result=stream.collect(Collectors.toList());
//      intermediate will be executed and then below
        System.out.println("After terminal operation");
        System.out.println(result);
    }
}
