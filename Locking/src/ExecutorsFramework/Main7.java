package ExecutorsFramework;

import java.lang.ref.SoftReference;
import java.util.concurrent.*;

//there is a problem in executor service will solve that
//vvvvIMP
//public class Main7 {
//    static void main() throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        Future<String> future1 = executorService.submit(new DependentService());
//        Future<String> future2 = executorService.submit(new DependentService());
//        Future<String> future3 = executorService.submit(new DependentService());
//
//        future1.get();
//        future2.get();
//        future3.get();
//
//        //to complete below task, all three dependant thread execution should be completed, so every time will have to write .get again or invoke all
//        //to solve this problem we can use countdown latch, this will make main service wait till execution completes
//        System.out.println("All dependent services finished. Started main service!");
//        executorService.shutdown();
//    }
//}

public class Main7 {
    static void main() throws ExecutionException, InterruptedException {
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices); //after this countdown the main service will execute
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        System.out.println("Main");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String>{
    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + "service started");
            Thread.sleep(2000);
        }finally {
            latch.countDown();
        }
        return "ok";
    }
}
