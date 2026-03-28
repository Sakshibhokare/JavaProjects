package Generics35;
//Generic types allow you to define a class, interface, or method with placeholders for the data types they will work with

//now this class is generic
//Bounded type parameter: first should be a class after that we can give multiple interfaces, we only can use extend here
public class Box<T extends Number> { //we added boundation, so we can only have type related to that bounded class
//    private Object value;
    private T value;
    public T getValue(){
        return value;
    };
    public void setValue(T value){
        this.value = value;
    }
}
