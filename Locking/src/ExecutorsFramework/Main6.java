package ExecutorsFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Scheduled Executor Service
public class Main6 {
    static void main() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(
                ()-> System.out.println("Task executed after 5 second delay!"),
                5,
                TimeUnit.SECONDS
        );
        scheduler.scheduleAtFixedRate(
                ()-> System.out.println("Task delayed again for 5 seconds"),
                5,
                5,
                TimeUnit.SECONDS
        );
        //this will make scheduler to wait for % minutes before starting new task
        scheduler.scheduleWithFixedDelay(()-> System.out.println("task executed after 5 minutes hold"),
                5,
                5,
                TimeUnit.SECONDS);


        //after total 20 seconds scheduler got shut down so we could have printed only 4 times
        scheduler.schedule(()->{
            System.out.println("Initiating shutdown...");
            scheduler.shutdown();
        },
                20,
                TimeUnit.SECONDS);
//        scheduler.shutdown(); //we are immediately calling shutdown so scheduled tasks are got ignored

//    Executors.newCachedThreadPool() //this will create thread on demand, but this should be used for small tasks, variable tasks, need to learn more
    }
}
