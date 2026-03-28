package Generics35;

public class GenericMethods {
    static void main() {
        //if we don't want to create object we can add static in method
//        GenericMethods genericMethods= new GenericMethods();
        Integer[] intArray = {1,2,3,4,5};
        String[] stringArray = {"hello", "world"};
       methodName(intArray);
        methodName(stringArray);
        display("Sakshi");
        display(23);
    }
    //similar to constructor but add method type
    public static  <T> void methodName(T[] array){
        for (T element: array){
            System.out.println(element + " ");
        }
        System.out.println();
    }

    //method overloading, if give int value second one will be called else first
    public static <T> void display(T element){
        System.out.println("Generic display: "+element);
    }

    public static void display(Integer element){
        System.out.println("Integer Display: "+element);
    }
}
