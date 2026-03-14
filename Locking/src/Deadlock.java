
class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + "is using pen " + this + " and trying to use ");
        paper.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + "finished using pen " + this);
    }
}
class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName()+"is using paper "+ this + " and trying to use ");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + "finished using pen " + this);
    }
}

class Task1 implements Runnable{
    private Pen pen;
    private  Paper paper;
    public Task1(Pen pen, Paper paper){
        this.pen= pen;
        this.paper=paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable{
    private Pen pen;
    private  Paper paper;
    public Task2(Pen pen, Paper paper){
        this.pen= pen;
        this.paper=paper;
    }

    @Override
    public void run() {
        //this will make sure to have access of pen, solves deadlock
//        synchronized (pen){
//            paper.writeWithPaperAndPen(pen);
//        }
        paper.writeWithPaperAndPen(pen);
    }
}
public class Deadlock {
    //Deadlock typically occur when four conditions are met simultaneously
    //Mutual Exclusion: Only one thread can access resource at a time
    //Hold and wait: A thread holding at least one resource is waiting to acquire additional resources held by other threads
    //No Preemption: Resources cannot be forcibly taken from thread holding them
    //Circular wait: A set of thread is waiting for each other in a circular chain

    static void main() {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen, paper), "Thread 1 ");
        Thread thread2 = new Thread(new Task2(pen, paper), "Tread 2 ");

        thread1.start();
        thread2.start();
    }
}
