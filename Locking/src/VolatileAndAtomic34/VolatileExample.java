package VolatileAndAtomic34;
class  SharedObject{
    //will use volatile for basic use case, just like flag
    private volatile boolean flag = false;
     //writer will run this
    public void  setFlagTrue(){
        System.out.println("writer thread made the flag true");
        flag = true;
    }
    //reader will run this
    public void printIfFlagTrue(){
        while (!flag){

        }
        System.out.println("flag is true!");
    }
}
public class VolatileExample {
    static void main() {
        SharedObject sharedObj = new SharedObject();
        Thread writerThread = new Thread(()->{
            try {
                Thread.sleep(1000); //we want reader to execute first
            }catch (InterruptedException e){
                Thread.currentThread().interrupt(); //this is for storing current state
            }
            sharedObj.setFlagTrue();
        });

        Thread readerThread = new Thread(()->sharedObj.printIfFlagTrue());
//reader thread is not able to get that flag is true, and that thread is got stuck in the loop,
        // because thread has a cached memory where they store the variable, so now will make changes in for reader thread to not store flag in the cached memory
        // will mark that variable as volatile, now the readerThread is not using the variable data from it's cached memory, stead using the data from main memory

        writerThread.start();
        readerThread.start();
    }
}
