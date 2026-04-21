package Revision.OOPsFundamentals1;

public class ThisAndSuper {
    static void main() {

//🔥 `this` vs `super` + Constructor Chaining (FAANG-Level Understanding)
//
//🧠 1. Core Idea (Don’t memorize—visualize)
//
//        When you create an object:
//
//```java
//        Child obj = new Child();
//```
//
//👉 Memory is allocated
//👉 Constructors execute in a **chain (top → bottom)**
//👉 Parent class initializes first, then child

//        ---
//
//# 🟢 `this` Keyword — “Current Object Reference”
//
//## 📌 What it does:
//
//`this` refers to the **current object instance**
//
//### ✅ Common Uses
//
//### 1. Resolve variable shadowing

        class Student {
            int age;

            Student(int age) {
                this.age = age; // refers to instance variable
            }
        }

//### 2. Call another constructor in same class (Constructor Chaining)


        class Student2 {
            String name;
            int age;

            Student2() {
                this("Unknown", 0); // calls parameterized constructor
            }

            Student2(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

//
//👉 This avoids duplication
//👉 MUST be first statement in constructor
//
//        ---
//
//### 3. Pass current object


//        void print(Student s) {}
//
//        print(this);


//        ---

//### 4. Return current object (Method chaining)

        class Builder {
            Builder setName() {
                return this;
            }
        }


//        ---

//# 🔴 `super` Keyword — “Parent Class Reference”
//
//## 📌 What it does:
//
//        Refers to **immediate parent class**

//        ---

//### 1. Access parent variables

        class Parent {
            int x = 10;
        }

        class Child extends Parent {
            int x = 20;

            void print() {
                System.out.println(super.x); // 10
            }
        }

//### 2. Call parent method


//        super.display();

//
//        ---
//
//### 3. Call parent constructor

        class parent {
            parent() {
                System.out.println("Parent Constructor");
            }
        }

        class child extends parent {
            child() {
                super(); // automatically added if not written
                System.out.println("Child Constructor");
            }
        }
//```

//        ---
//
//# 🔗 Constructor Chaining (VERY IMPORTANT 🔥)
//
//## 📌 Rule:
//
//👉 Constructor execution flows **top to bottom (parent →child)**
//👉 Within same class: `this()`
//👉 Across classes: `super()`

//        ---;

//## 🧩 Flow Example
//
//```java
        class A {
            A() {
                System.out.println("A");
            }
        }

        class B extends A {
            B() {
                System.out.println("B");
            }
        }

        class C extends B {
            C() {
                System.out.println("C");
            }
        }
//```
//
//### Output:
//
//```
//        A
//         B
//        C
//```
//
//        ---
//
//## 🧠 What Actually Happens Internally
//
//```java
//        new C();
//```
//
//👉 C() calls B()
//👉 B() calls A()
//👉 A() executes
//👉 B() executes
//👉 C() executes
//
//                ---
//
//# ⚠️ Critical Rules (Interview Killers)
//
//### ❌ Rule 1: `this()` and `super()` must be FIRST line
//
//```java
//        this();  // must be first
//        super(); // must be first
//```
//
//        ---
//
//### ❌ Rule 2: Cannot use both together
//
//```java
//        this();
//        super(); // ❌ Compile-time error
//```
//
//        ---
//
//### ❌ Rule 3: If no constructor → default `super()` added
//
//```java
//        Child() {
//            // compiler inserts super();
//        }
//```
//
//        ---
//
//### ❌ Rule 4: If parent has NO default constructor → MUST call explicitly
//
//```java
//        class Parent {
//            Parent(int x) {}
//        }
//
//        class Child extends Parent {
//            Child() {
//                super(10); // mandatory
//            }
//        }
//```
//
//        ---
//
//# 🧠 FAANG-Level Deep Insight
//
//### 👉 Why `this()` and `super()` must be first?
//
//                Because object initialization must be **deterministic and complete before usage**
//
//👉 Java ensures:
//
//* Parent state initialized first
//* Then child state
//
//                ---
//
//# 🧠 Interview Googly Questions 🔥
//
//## ❓1. What happens here?


        class a {
            a() {
                this(10);
                System.out.println("A");
            }

            a(int x) {
                System.out.println("Param A");
            }
        }

//
//### ✅ Output:
//
//        Param A
//        A
//
//
//## ❓2. Can we call constructor from a method using `this()`?
//
//👉 ❌ NO
//`this()` only inside constructor
//
//                ---
//
//## ❓3. Can constructor be private and still used?
//
//👉 ✅ YES (Singleton pattern)
//
//                ---
//
//## ❓4. What is printed?
//
//        class Parent {
//            Parent() {
//                System.out.println("Parent");
//            }
//        }
//
//        class Child extends Parent {
//            Child() {
//                this(10);
//                System.out.println("Child");
//            }
//
//            Child(int x) {
//                System.out.println("Child Param");
//            }
//        }
//```
//
//### ✅ Output:
//
//```
//        Parent
//        Child Param
//        Child
//```
//
//👉 Flow:
//
//* Child() → this(10)
//                * Child(int) → calls super() → Parent()
//                * Then Child(int)
//* Then Child()
//
//                ---
//
//## ❓5. Trick Question
//
//```java
//        class Test {
//            Test() {
//                System.out.println(this);
//            }
//        }
//```
//
//👉 Prints object reference → `Test@hashcode`
//
//        ---
//
//## ❓6. Can we use `this` in static method?
//
//👉 ❌ NO (no object context)
//
//                ---
//
//## ❓7. What happens if you don't call `super()`?
//
//👉 Compiler inserts it automatically (if default exists)
//
//        ---
//
//## ❓8. Multiple inheritance + `super`?
//
//👉 Java doesn’t support multiple inheritance (class), so no ambiguity
//
//                ---
//
//# 🧪 FAANG Coding Twist
//
//### Builder Pattern (real-world usage of `this`)
//
//```java
//        class User {
//            String name;
//            int age;
//
//            User setName(String name) {
//                this.name = name;
//                return this;
//            }
//
//            User setAge(int age) {
//                this.age = age;
//                return this;
//            }
//        }
//```
//
//        ---
//
//# ⚡ Summary (What interviewer expects)
//
//        You should confidently say:
//
//* `this` → current object
//* `super` → parent object
//* `this()` → constructor chaining (same class)
//* `super()` → parent constructor call
//    * Execution order → **Parent → Child**
//   * Both must be first statement
//* Cannot use together
//


    }
}
