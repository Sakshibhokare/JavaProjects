package ThreadCommunication;

public class LambdaExpression {
    //Lambda expression: Anonymous function
    //() -> {} this is a lambda expression, instead of writing public static void main
    static void main() {
        //Runnable had only one function
        Runnable runnable = ()->{
            System.out.println("Hello");
        };
//        Student lawStudent = name -> System.out.println(name + " is a law student ");  we can also write this when have only one statement
//        student newStudent = name -> name + " is a Engineer " when have only one statement to return
        Thread thread1 = new Thread(runnable, "lambda expression");
        thread1.start();
        Thread t2 = new Thread(()-> System.out.println("without anonymous class"));
        t2.start();
        Thread t3 = new Thread(()->{
            System.out.println("multiple line 1");
            System.out.println("Mutiple line 2");
        });
        t3.start();
    }
}
