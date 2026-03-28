package Generics35;
//java does not support generic exceptions due to type erasure.
//In Java, generics are removed at compile time. The compiler replaces type parameters with their bounds (or Object).
//Problem with Exceptions
//Java exception handling depends on runtime type checking.

//Use:
//Specific exception classes (best)
//Or composition (store data inside exception)
//public class GenericExceptions<T> extends Exception {
//
//}

//so we need to create
public class GenericExceptions extends Exception {
    static void main() {
        try {
            throw new MyException(123);
        }catch (MyException e){
            System.out.println("Caught exception: " + e.getMessage());
        }

        try{
            throw new MyException("string");
        }catch (MyException e){
            System.out.println("caught exception in string: " + e.getMessage());
        }
    }
}

class MyException extends Exception{
    public <T> MyException(T value){
        super("Exception related to value: " +
                value.toString()+
                " of type: "+
                value.getClass().getName()  //here will get to know that java compiler replaces type parameters with their bounds
                );
    }
}