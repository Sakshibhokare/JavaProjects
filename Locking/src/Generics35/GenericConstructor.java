package Generics35;

class box0 <T>{
    private T value;
    box0(T value){
        this.value = value;
    }
}

//even if the class is not generic, it's constructor can be generic
class box2{
   <T> box2(T vale){

    }
}
public class GenericConstructor {
    static void main() {
        box2 boxx= new box2(2);
    }
}
