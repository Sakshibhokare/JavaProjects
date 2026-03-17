package ThreadCommunication;
class SharedResource{
    private int data;
    private boolean hasData;
    //if data is already present then do not produce, wait
    public synchronized void produce(int value){
        while (hasData){
            try{
                wait();
            }catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data=value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); //notify consumer to consume data
        //notify and wait are not synchronized then we must use synchronized key word
    }
    //is data is present then consume that
    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData=false; //since we consumed data
        System.out.println("Consumed: " + data);
        notify(); //notify to producer to produce data
        return data;
    }
}

class Producer implements Runnable{
    private SharedResource resource;
    public Producer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            resource.produce(i);
        }
    }
}
class Consumer implements Runnable{
    private SharedResource resource;
    public Consumer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            int value = resource.consume();
        }
    }
}
public class ThreadCommunication {
    static void main() {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
    }
}
