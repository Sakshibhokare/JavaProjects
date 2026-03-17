package ExecutorsFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//Executors Methods
public class Main5 {
    static void main() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> call1 = ()->{
            Thread.sleep(1000);
            System.out.println("task 1");
            return  1;
        };
        Callable<Integer> call2 = ()->{
            Thread.sleep(1000);
            System.out.println("task 2");
            return 2;
        };
        Callable<Integer> call3 = ()->{
            Thread.sleep(1000);
            System.out.println("task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(call1,call2,call3);
       //invoke will block main method, till all tasks gets completed
        //we can give time out as well so that invoke method will only wait till that time after that it will give time out error
        for (Future<Integer> integerFuture : executor.invokeAll(list, 1, TimeUnit.SECONDS)) {
            System.out.println(integerFuture.get());
        }

        executor.shutdown();
        System.out.println("will get printed in last");


    }
}
