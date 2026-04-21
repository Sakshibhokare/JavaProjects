//package Revision.OOPsFundamentals1;
////Method Overriding, Super keyword, polymorphism
//public class MethodOverridingPoly {
//
//    This is a **core OOP cluster**—and FAANG interviews LOVE mixing these topics into tricky output questions.
//
//            I’ll go deep but structured so you can *revise fast + think like an interviewer*.
//
//            ---
//
//            # 🔥 1. Method Overriding (Runtime Polymorphism Core)
//
//## 🧠 Definition (Real Understanding)
//
//👉 Method overriding = **Child provides its own implementation of parent method**
//
//            ```java
//    class Animal {
//        void sound() {
//            System.out.println("Animal sound");
//        }
//    }
//
//    class Dog extends Animal {
//        @Override
//        void sound() {
//            System.out.println("Bark");
//        }
//    }
//```
//
//        ---
//
//        ## ⚡ How Java Decides Which Method to Call?
//
//            ```java
//    Animal a = new Dog();
//a.sound();
//```
//
//        👉 Output: `Bark`
//
//            📌 WHY?
//
//            * Reference type → `Animal`
//            * Object type → `Dog`
//            * 👉 JVM uses **object type (runtime decision)**
//
//            ---
//
//            # 📜 Rules of Method Overriding (FAANG MUST KNOW)
//
//---
//
//        ## ✅ 1. Same Method Signature
//
//```java
//    void show(int x)
//```
//
//        ---
//
//        ## ✅ 2. Same / Covariant Return Type
//
//```java
//    class A {
//        A get() { return this; }
//    }
//
//    class B extends A {
//        B get() { return this; } // ✅ covariant
//    }
//```
//
//        👉 Return type can be **child type**
//
//            ---
//
//            ## ❌ 3. Cannot Reduce Access Modifier
//
//| Parent    | Child Allowed                |
//            | --------- | ---------------------------- |
//            | public    | public                       |
//            | protected | protected / public           |
//            | default   | default / protected / public |
//
//            ---
//
//            ## ❌ 4. Cannot Override static methods
//
//```java
//    class A {
//        static void show() {}
//    }
//
//    class B extends A {
//        static void show() {} // method hiding
//    }
//```
//
//        👉 This is **method hiding**, NOT overriding
//
//---
//
//        ## ❌ 5. Cannot Override final methods
//
//```java
//    final void show() {}
//```
//
//        ---
//
//        ## ❌ 6. Cannot Override private methods
//
//👉 Because they are NOT inherited
//
//---
//
//        ## ✅ 7. Exception Rules (VERY TRICKY)
//
//👉 Child can:
//
//            * Throw **same exception**
//            * Throw **subclass exception**
//            * Throw **no exception**
//
//            ❌ Cannot throw broader exception
//
//---
//
//        ## 🔥 Example
//
//```java
//    class A {
//        void show() throws Exception {}
//    }
//
//    class B extends A {
//        void show() throws IOException {} // ✅ valid
//    }
//```
//
//        ---
//
//        # 🔥 Covariant Return Types (INTERVIEW FAVORITE)
//
//## 🧠 Idea:
//
//    Return **more specific type**
//
//            ```java
//    class Animal {}
//
//    class Dog extends Animal {}
//
//    class A {
//        Animal getAnimal() {
//            return new Animal();
//        }
//    }
//
//    class B extends A {
//        Dog getAnimal() { // ✅ covariant
//            return new Dog();
//        }
//    }
//```
//
//        👉 Helps in:
//
//            * Cleaner APIs
//* Fluent design
//
//---
//
//        # 🔥 `super` Keyword (Deep Understanding)
//
//---
//
//        ## 🟢 1. Access Parent Variable
//
//```java
//    class A {
//        int x = 10;
//    }
//
//    class B extends A {
//        int x = 20;
//
//        void print() {
//            System.out.println(super.x); // 10
//        }
//    }
//```
//
//        ---
//
//        ## 🟢 2. Call Parent Method
//
//```java
//    class A {
//        void show() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        void show() {
//            super.show(); // call parent
//            System.out.println("B");
//        }
//    }
//```
//
//        ---
//
//        ## 🟢 3. Call Parent Constructor
//
//```java
//    class A {
//        A() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        B() {
//            super(); // implicit
//            System.out.println("B");
//        }
//    }
//```
//
//        ---
//
//        # ⚠️ Important `super` Rules
//
//* Must be **first statement** (constructor)
//            * Refers to **immediate parent only**
//            * Cannot be used in static context
//
//---
//
//        # 🔥 Polymorphism (Big Picture)
//
//---
//
//        # 🟡 1. Compile-Time Polymorphism (Overloading)
//
//👉 Same method name, different parameters
//
//```java
//    class MathUtils {
//        int add(int a, int b) { return a + b; }
//        double add(double a, double b) { return a + b; }
//    }
//```
//
//        ---
//
//        ## 🧠 Resolution:
//
//            👉 Decided at **compile time**
//
//            ---
//
//            ## ⚠️ Trick:
//
//            ```java
//    void show(int a)
//    void show(Integer a)
//```
//
//        👉 Depends on **autoboxing + priority rules**
//
//            ---
//
//            ---
//
//            # 🔴 2. Runtime Polymorphism (Overriding)
//
//👉 Already covered
//
//```java
//    Animal a = new Dog();
//a.sound(); // runtime decision
//```
//
//        ---
//
//        # 🧠 FAANG Deep Insight
//
//---
//
//        ## 🔥 1. Method Call Resolution Order
//
//| Type        | Decided By    |
//            | ----------- | ------------- |
//            | Overloading | Compiler      |
//            | Overriding  | JVM (runtime) |
//
//            ---
//
//            ## 🔥 2. Variable vs Method
//
//```java
//    class A {
//        int x = 10;
//    }
//
//    class B extends A {
//        int x = 20;
//    }
//
//    A obj = new B();
//System.out.println(obj.x); // 10
//```
//
//        👉 Variables → **compile-time binding**
//
//            👉 Methods → **runtime binding**
//
//            ---
//
//            # 🔥 Interview Googly Questions (VERY IMPORTANT)
//
//---
//
//        ## ❓1. What is output?
//
//            ```java
//    class A {
//        void show() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        void show() {
//            System.out.println("B");
//        }
//    }
//
//    public class Test {
//        public static void main(String[] args) {
//            A obj = new B();
//            obj.show();
//        }
//    }
//```
//
//        👉 Output: `B`
//
//            ---
//
//            ## ❓2. Static method confusion
//
//```java
//    class A {
//        static void show() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        static void show() {
//            System.out.println("B");
//        }
//    }
//
//    A obj = new B();
//obj.show();
//```
//
//        👉 Output: `A`
//            👉 Because static → compile-time
//
//---
//
//        ## ❓3. Can we override main()?
//
//            👉 ❌ NO (it's static)
//
//            ---
//
//            ## ❓4. What happens here?
//
//            ```java
//            class A {
//        A get() { return this; }
//    }
//
//    class B extends A {
//        @Override
//        B get() { return this; }
//    }
//```
//
//        👉 ✅ Valid → Covariant return
//
//            ---
//
//            ## ❓5. Overloading trap
//
//```java
//    void show(int a)
//    void show(long a)
//```
//
//        ```java
//    show(10); // int literal
//```
//
//        👉 Calls `show(int)`
//
//            ---
//
//            ## ❓6. Null ambiguity
//
//```java
//    void show(String s)
//    void show(Integer i)
//
//    show(null); // ❓
//```
//
//        👉 ❌ Compile-time error (ambiguous)
//
//---
//
//        ## ❓7. Final + overriding
//
//```java
//    final void show() {}
//```
//
//        👉 Cannot override → compile error
//
//---
//
//        ## ❓8. Private method trick
//
//```java
//    class A {
//        private void show() {}
//    }
//
//    class B extends A {
//        void show() {} // NOT overriding
//    }
//```
//
//        👉 This is a new method
//
//---
//
//        ## ❓9. Super + override combo
//
//```java
//    class A {
//        void show() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        void show() {
//            super.show();
//            System.out.println("B");
//        }
//    }
//```
//
//        👉 Output:
//
//            ```
//    A
//            B
//```
//
//        ---
//
//        # 🔥 FAANG-Level Trick Question
//
//```java
//    class A {
//        void show() {
//            System.out.println("A");
//        }
//    }
//
//    class B extends A {
//        void show(int x) {
//            System.out.println("B");
//        }
//    }
//
//    A obj = new B();
//obj.show();
//```
//
//        👉 Output: `A`
//
//            👉 WHY?
//
//            * No overriding (signature different)
//* Only overloading
//
//---
//
//        # 🚀 One-Line Killer Answers
//
//### ✅ Overriding:
//
//            > “Runtime polymorphism where method resolution depends on object type.”
//
//            ### ✅ Overloading:
//
//            > “Compile-time polymorphism resolved using method signature.”
//
//            ### ✅ Covariant Return:
//
//            > “Allows returning subtype in overridden method.”
//
//            ### ✅ super:
//
//            > “Used to access immediate parent’s constructor, method, or field.”
//
//            ---
//
//            # ⚡ Final Mental Model
//
//* **Overloading → Compiler → Early binding**
//            * **Overriding → JVM → Late binding**
//            * **Variables → Compile-time**
//            * **Methods → Runtime (if overridden)**
//
//            ---
//
//    If you want next level:
//
//            👉 I can give:
//
//            * 20 FAANG-level MCQs (output-based traps)
//* Real Google/Amazon questions mixing all OOP concepts
//* LLD problems using polymorphism
//
//    Send next topic 🚀
//
//}

//⚡ In one line (FAANG-ready):

//Overriding is not compile-time because the compiler only knows the reference type, but the JVM decides the method based on the actual object at runtime (dynamic binding).
