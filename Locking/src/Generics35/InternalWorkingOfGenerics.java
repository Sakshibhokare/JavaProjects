package Generics35;
//1. Compiler checks types
//2. Removes generic types (type erasure)
//3. Replaces T with Object
//4. Adds type casting where needed for example,

//Java generics use type erasure. Type information is checked at compile time and removed during compilation.
//At runtime, all generic types are treated as Object, and necessary type casting is added by the compiler.
public class InternalWorkingOfGenerics {
    class Box<T> {
        T value;

        void set(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

//    after type erasure, only T then Object, if used class like Number then Number, type casting will be done by java
//class Box {
//    Object value;
//
//    void set(Object value) {
//        this.value = value;
//    }
//
//    Object get() {
//        return value;
//    }
//}
}
