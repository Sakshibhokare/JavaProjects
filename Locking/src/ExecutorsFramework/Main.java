package ExecutorsFramework;
//this is complete manual thread creation, not reusing threads
//created 9 separate threads
public class Main {
    static void main() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //when multiple thread are running, and you want to perform action after completing execution of all threads,
        //then will create an array of threads
        //we are creating 9 threads, each will take 1 second and run in parallel, then total time will be 1 second approx
        Thread[] threads = new Thread[9];

        for(int i=1; i<10; i++){
            int finalI = i;

            threads[i-1] = new Thread(()->{
                long result = 0;
                try {
                    result = factorial(finalI);
                    System.out.println(result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threads[i-1].start();
        }
        //waiting for all thread to complete execution
        for (Thread thread: threads){
            try {
                thread.join();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) throws InterruptedException {
        Thread.sleep(1000);
        long result =1;
        for(int i=1; i<=n; i++){
            result*=i;
        }
        return result;
    }
}
