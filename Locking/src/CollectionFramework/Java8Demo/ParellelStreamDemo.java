package CollectionFramework.Java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
//7:07
public class ParellelStreamDemo {
    static void main() {
        //A type of stream that enables parallel processing of elements
        //Allowing multiple threads to process parts of the stream simultaneously
        //This can significantly improve performance for large data sets
        //workload is distribute across multiple threads
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialList = list.stream().map(x -> factorial(x)).toList();
        long endtime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endtime - startTime) + " ms");

        //Parallel Stream are most effective for CPU-intensive or large datasets where tasks are independent
        //They may add overhead for simple task or small datasets, performance will decrease
        long newstartTime = System.currentTimeMillis();
        List<Integer> list1 = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialListnew = list1.parallelStream().map(x -> factorial(x)).toList();
        long newendtime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (newendtime - newstartTime) + " ms");

        // Cumulative sum
        // [1,2,3,4,5] --> [1,3,6,20,15] sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> list2 =numbers.parallelStream().map(x->sum.addAndGet(x)).toList();//using stream here answer will be correct
        System.out.println("Expected comulative sum: [1,3,6,10,15]");
        System.out.println("Actual result with parallel stream" + list2); //this is not independent so we can not do this parallel, parallelStream never guarantees order of execution


        //convert parallel stream to sequential
        List<Integer> list3 = Stream.iterate(1, x -> x + 1).limit(5).toList();
        List<Long> factorialListSeq = list.stream().map(x -> factorial(x)).sequential().toList();
        System.out.println("5 limit " + factorialListSeq);



    }

private static long factorial(int n){
    long result = 1;
    for(int i=2; i<=n; i++){
        result*=i;
    }
    return result;
}
}
