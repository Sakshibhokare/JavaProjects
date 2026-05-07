package Revision.OOPsFundamentals1;

public class FinalRevision {
    static void main() {
        Integer a = 200;
        Integer b = 200;
        System.out.println(a==b);
//
//        You’re essentially asking for a **full Java core revision at a system-design + Spring Boot level**—exactly how FAANG/Atlassian expect you to think: not syntax, but **why, when, and tradeoffs**.
//
//        I’ll compress this into **high-signal sections** you can revise before interviews.
//
//        ---
//
//# 🔥 1. Static vs Instance (Deep + Practical)
//
//## 🧠 Core Idea
//
//|               |   Type   | Meaning                   |
//                | -------- | ------------------------- |
//                | Static   | Belongs to class (shared) |
//                | Instance | Belongs to object         |
//
//        ---
//
//## 🟢 Variables
//
//```java
//        class User {
//            static int userCount = 0; // shared
//            String name;              // per object
//        }
//```
//
//👉 In Spring Boot:
//
//* `static` → config, constants, caches
//                * instance → request-specific data
//
//                ---
//
//## 🟢 Methods
//
//```java
//        static void util() {}   // utility (no object)
//        void process() {}       // business logic
//```
//
//👉 Example:
//
//* `Math.max()` → static
//* `userService.saveUser()` → instance
//
//                ---
//
//## 🟢 Static Block (VERY TRICKY)
//
//```java
//        static {
//            System.out.println("Runs once when class loads");
//        }
//```
//
//👉 Used in:
//
//* Driver loading
//* Config initialization
//
//        ---
//
//## 🟢 Instance Block (rare but asked)
//
//```java
//        {
//            System.out.println("Runs before constructor");
//        }
//```
//
//        ---
//
//## 🟢 Static Inner Class (IMPORTANT)
//
//```java
//        class Outer {
//            static class Inner {}
//        }
//```
//
//👉 Used in:
//
//* Builder Pattern
//* DTO grouping
//
//        ---
//
//## ⚠️ FAANG Trap
//
//```java
//        A obj = new B();
//        System.out.println(obj.x); // variable
//```
//
//👉 Variables → compile-time
//👉 Methods → runtime
//
//                ---
//
//# 🔥 2. final vs finally vs finalize
//
//        ---
//
//## 🟢 final (Keyword)
//
//```java
//        final int x = 10;        // constant
//        final class A {}         // no inheritance
//        final void show() {}     // no overriding
//```
//
//👉 Used in:
//
//* Immutable objects
//* Security-critical logic
//
//                ---
//
//## 🟡 finally (Block)
//
//```java
//        try {
//        } finally {
//            // always executes
//        }
//```
//
//👉 Used for:
//
//* Closing DB connections
//                * Cleanup
//
//                ---
//
//## 🔴 finalize (Deprecated concept)
//
//```java
//        protected void finalize() {}
//```
//
//👉 Called by GC (not reliable)
//
//❌ Don’t use in modern Java
//👉 Use `try-with-resources`
//
//        ---
//
//## 🧠 Interview One-liner
//
//                > final = keyword, finally = cleanup block, finalize = GC hook (deprecated)
//
//                ---
//
//# 🔥 3. Constructors (FAANG Depth)
//
//                ---
//
//## 🟢 Types
//
//### Default
//
//```java
//        User() {}
//```
//
//### Parameterized
//
//```java
//        User(String name) {}
//```
//
//        ---
//
//## 🟢 Copy Constructor (Manual in Java)
//
//```java
//        User(User other) {
//            this.name = other.name;
//        }
//```
//
//👉 Used in:
//
//* Defensive copying
//* Immutability
//
//                ---
//
//## 🔗 Constructor Chaining
//
//```java
//        User() {
//            this("default");
//        }
//
//        User(String name) {
//            this.name = name;
//        }
//```
//
//👉 `this()` → same class
//👉 `super()` → parent class
//
//        ---
//
//## ⚠️ Rule
//
//                * Must be first statement
//                * Cannot use both together
//
//                ---
//
//## 🧠 Spring Boot Insight
//
//👉 Constructors used for:
//
//* **Dependency Injection**
//
//```java
//public UserService(UserRepository repo) {}
//```
//
//        ---
//
//# 🔥 4. Interface vs Abstract Class (REAL USE)
//
//        ---
//
//## 🧠 Modern Reality (Java 8+)
//
//        Interfaces are heavily used in Spring
//
//        ---
//
//## 🟢 Interface
//
//```java
//        public interface PaymentService {
//            void pay();
//        }
//```
//
//👉 Used for:
//
//* Loose coupling
//* Multiple implementations
//
//        ---
//
//## 🟢 Abstract Class
//
//```java
//        abstract class BaseService {
//            void log() {}
//        }
//```
//
//👉 Used for:
//
//* Shared logic
//
//        ---
//
//## ⚡ Default Methods
//
//```java
//        interface A {
//            default void show() {}
//        }
//```
//
//        ---
//
//## ⚡ Functional Interface (VERY IMPORTANT)
//
//```java
//        @FunctionalInterface
//        interface MyFunc {
//            void apply();
//        }
//```
//
//👉 Used in:
//
//* Streams
//                * Lambdas
//                * Spring callbacks
//
//                ---
//
//## 🧠 When to Use
//
//                | Use Case            | Choose         |
//                | ------------------- | -------------- |
//                | Multiple behavior   | Interface      |
//                | Shared code + state | Abstract class |
//                | Microservices       | Interface      |
//
//                ---
//
//# 🔥 5. Wrapper Classes + Autoboxing
//
//                ---
//
//## 🟢 Wrapper Classes
//
//```java
//        int → Integer
//        double → Double
//```
//
//        ---
//
//## 🟢 Autoboxing
//
//```java
//        Integer x = 10;
//```
//
//## 🟢 Unboxing
//
//```java
//        int y = x;
//```
//
//        ---
//
//## ⚠️ FAANG Trap
//
//```java
//        Integer a = 100;
//        Integer b = 100;
//
//        System.out.println(a == b); // true (cache)
//```
//
//```java
//        Integer a = 200;
//        Integer b = 200;
//
//        System.out.println(a == b); // false
//```
//
//👉 Cache range: **-128 to 127**
//
//                ---
//
//# 🔥 6. String Internals (VERY IMPORTANT)
//
//        ---
//
//## 🧠 String Pool
//
//```java
//        String s1 = "hello";
//        String s2 = "hello";
//```
//
//👉 Both point to same object (pool)
//
//                ---
//
//## ❌ But:
//
//```java
//        String s1 = new String("hello");
//```
//
//👉 Creates new object (heap)
//
//                ---
//
//## 🟢 Immutability
//
//```java
//        String s = "abc";
//        s.concat("def"); // new object
//```
//
//👉 Reasons:
//
//* Security
//                * Thread safety
//                * Caching
//
//                ---
//
//## ⚔️ String vs StringBuilder vs StringBuffer
//
//                | Type          | Thread-safe | Performance |
//                | ------------- | ----------- | ----------- |
//                | String        | Yes         | Slow        |
//                | StringBuilder | No          | Fast        |
//                | StringBuffer  | Yes         | Medium      |
//
//                ---
//
//## 🧠 Spring Insight
//
//👉 Use `StringBuilder` in loops/logs
//
//                ---
//
//# 🔥 7. Varargs
//
//```java
//        void print(int... nums) {}
//```
//
//👉 Internally → array
//
//                ---
//
//## ⚠️ Rules
//
//                * Only one vararg
//* Must be last parameter
//
//        ---
//
//# 🔥 8. Covariant Return Types
//
//                ---
//
//## 🧠 Concept
//
//        Child can return more specific type
//
//```java
//        class A {
//            Animal get() {}
//        }
//
//        class B extends A {
//            Dog get() {} // valid
//        }
//```
//
//        ---
//
//## 🧠 Why useful?
//
//* Cleaner APIs
//* Fluent design
//
//        ---
//
//# 🔥 REAL FAANG COMBINED QUESTION
//
//        ---
//
//## ❓ Predict Output
//
//```java
//        String s1 = "hello";
//        String s2 = new String("hello");
//
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//```
//
//👉 Output:
//
//```text
//        false
//        true
//```
//
//        ---
//
//# 🔥 SYSTEM DESIGN CONNECTION (IMPORTANT)
//
//                ---
//
//## Example: Payment System
//
//* Interface → `PaymentService`
//* Polymorphism → Stripe, Razorpay
//                * Encapsulation → DTO
//                * Immutability → Request objects
//* Static → Utility methods
//* StringBuilder → logging
//
//                ---
//
//# 🚀 FINAL INTERVIEW ANSWER (Use This)
//
//                > “In real-world Spring Boot systems, static members are used for shared configurations and utilities,
//                while instance members handle request-specific logic. Constructors enable dependency injection.
//                Interfaces are preferred for loose coupling and polymorphism, while abstract classes are used for shared behavior.
//                Wrapper classes and autoboxing simplify handling primitives in collections.
//                String immutability ensures thread safety and efficient pooling, while StringBuilder is used for performance.
//                Features like varargs and covariant return types improve API flexibility and readability.”
//
//      “Java caches Integer objects from -128 to 127 using IntegerCache.
//      So autoboxed Integers in this range point to the same object, making == return true.
//      Outside this range, new objects are created, so == becomes false.
//      .equals() should be used for value comparison.”

    }
}
