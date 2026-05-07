package Revision.OOPsFundamentals1;
//
public class Abstraction1 {
    static void main() {

    }
    }
//
//
//# 🔥 Abstraction in Java — FAANG Level Deep Understanding
//
//```java
//package Revision.OOPsFundamentals1;
//
//        public class Abstraction1 {
//            static void main() {
//
//            }
//        }
//```
//
//        This topic is EXTREMELY important for:
//
//* FAANG backend interviews
//                * Atlassian
//                * Spring Boot design discussions
//                * LLD interviews
//                * Java 8+ questions
//
//        Interviewers test:
//
//* OOP understanding
//* design thinking
//* API design
//* runtime behavior
//* multiple inheritance issues
//                * functional programming concepts
//
//        ---
//
//# 🔥 1. What is Abstraction?
//
//                Abstraction means:
//
//```text
//        Hide implementation details and expose only essential behavior.
//```
//
//        ---
//
//# 🧠 Real World Example
//
//        Car driver:
//
//* knows:
//
//  * accelerate()
//                * brake()
//                * steering()
//
//        Does NOT know:
//
//* engine internals
//* fuel injection system
//
//                ---
//
//# 🔥 Java Achieves Abstraction Using
//
//        ---
//
//# ✅ Abstract Classes
//
//        AND
//
//# ✅ Interfaces
//
//                ---
//
//# 🔥 2. Abstract Class — Deep Understanding
//
//        ---
//
//# ✅ Definition
//
//        A class declared with:
//
//```java
//        abstract
//```
//
//        cannot be instantiated directly.
//
//        ---
//
//# Example
//
//```java
//        abstract class PaymentService {
//
//            abstract void pay();
//
//            void validate() {
//                System.out.println("Validation logic");
//            }
//        }
//```
//
//        ---
//
//# 🔥 Important Properties
//
//        ---
//
//## ✅ Can Have
//
//* abstract methods
//* concrete methods
//* constructors
//                * instance variables
//                * static methods
//* final methods
//
//        ---
//
//## ❌ Cannot
//
//                * create object directly
//
//        ---
//
//# 🔥 Why Abstract Class Exists?
//
//        Used when:
//
//```text
//        Common base behavior + partial abstraction needed
//```
//
//        ---
//
//# 🔥 Spring Boot Real Example
//
//```java
//        abstract class NotificationService {
//
//            void logNotification() {
//                System.out.println("Logging...");
//            }
//
//            abstract void send();
//        }
//```
//
//        ---
//
//# Child Classes
//
//```java
//        class EmailService extends NotificationService {
//            void send() {
//                System.out.println("Email sent");
//            }
//        }
//```
//
//        ---
//
//# 🔥 3. Why Can't We Create Object of Abstract Class?
//
//                ---
//
//# 🧠 Because Abstract Methods May Be Incomplete
//
//```java
//        abstract void pay();
//```
//
//        No implementation exists.
//
//                So JVM cannot create complete object behavior.
//
//        ---
//
//# ❓Then How Subclass Object Works?
//
//                Subclass provides implementation.
//
//```java
//        class UpiPayment extends PaymentService {
//
//            void pay() {
//                System.out.println("UPI payment");
//            }
//        }
//```
//
//        Now object is complete.
//
//        ---
//
//# 🔥 4. Interface — Deep Understanding
//
//        ---
//
//# ✅ Definition
//
//        An interface defines:
//
//```text
//        Contract / capability
//```
//
//        ---
//
//# Example
//
//```java
//        interface Payment {
//
//            void pay();
//        }
//```
//
//        ---
//
//# 🔥 Before Java 8
//
//        Interfaces had ONLY:
//
//* abstract methods
//* public static final variables
//
//        ---
//
//# 🔥 Java 8+
//
//                Interfaces can have:
//
//* default methods
//                * static methods
//
//        ---
//
//# 🔥 Java 9+
//
//                Interfaces can also have:
//
//* private methods
//
//        ---
//
//# 🔥 5. Interface Internals
//
//        ---
//
//# Every Method Is Implicitly
//
//```java
//        public abstract
//```
//
//        ---
//
//# Every Variable Is Implicitly
//
//```java
//        public static final
//```
//
//        ---
//
//# Example
//
//```java
//        interface A {
//            int x = 10;
//        }
//```
//
//        Internally:
//
//```java
//        public static final int x = 10;
//```
//
//        ---
//
//# ❌ Trap
//
//```java
//                x = 20;
//```
//
//        NOT allowed.
//
//        ---
//
//# 🔥 6. Abstract Class vs Interface (VERY IMPORTANT)
//
//| Feature               | Abstract Class | Interface                      |
//                | --------------------- | -------------- | ------------------------------ |
//                | Multiple inheritance  | ❌              | ✅                              |
//| Constructors          | ✅              | ❌                              |
//| Instance variables    | ✅              | ❌                              |
//| Method implementation | ✅              | ✅                              |
//| State allowed         | ✅              | ❌                              |
//| Access modifiers      | Any            | public only (abstract methods) |
//| Object creation       | ❌              | ❌                              |
//
//        ---
//
//# 🔥 When To Use Which? (VERY IMPORTANT)
//
//        ---
//
//# ✅ Use Abstract Class When
//
//        You need:
//
//* common state
//* shared implementation
//* base class behavior
//
//Example:
//
//```text
//                PaymentService
//        NotificationService
//                AbstractRepository
//```
//
//        ---
//
//# ✅ Use Interface When
//
//        You need:
//
//```text
//        Capability / contract
//```
//
//        Example:
//
//```text
//                Runnable
//        Comparable
//                Serializable
//```
//
//        ---
//
//# 🔥 FAANG-Level Design Thinking
//
//        ---
//
//# Abstract Class = IS-A Relationship
//
//```text
//        Dog IS-A Animal
//```
//
//        ---
//
//# Interface = CAN-DO Relationship
//
//```text
//        Bird CAN Fly
//```
//
//        ---
//
//# 🔥 7. Multiple Inheritance via Interfaces
//
//        Java does NOT allow:
//
//```java
//        class C extends A, B ❌
//```
//
//        because of:
//
//```text
//        Diamond Problem
//```
//
//        ---
//
//# Example
//
//```java
//        class A {
//            void show() {}
//        }
//
//        class B {
//            void show() {}
//        }
//```
//
//        If:
//
//```java
//        class C extends A, B
//```
//
//        Which `show()` should JVM call?
//
//                Ambiguity.
//
//                        ---
//
//# 🔥 But Interfaces Allow It
//
//        Because interfaces originally had:
//
//```text
//        No implementation
//```
//
//        No ambiguity.
//
//        ---
//
//# Example
//
//```java
//        interface A {
//            void show();
//        }
//
//        interface B {
//            void show();
//        }
//
//        class C implements A, B {
//
//            public void show() {
//                System.out.println("Implemented");
//            }
//        }
//```
//
//        ---
//
//# 🔥 8. Default Methods (Java 8)
//
//        VERY IMPORTANT.
//
//        ---
//
//# Why Introduced?
//
//        To:
//
//```text
//        Add methods without breaking old implementations
//```
//
//        ---
//
//# Example
//
//```java
//        interface Payment {
//
//            default void log() {
//                System.out.println("Logging");
//            }
//        }
//```
//
//        ---
//
//# 🔥 Real Need
//
//        Suppose Java added:
//
//```java
//        stream()
//```
//
//        to Collection interface.
//
//        Without default methods:
//
//* ALL implementations break
//
//                Default methods solved this.
//
//                ---
//
//# 🔥 9. Static Methods in Interfaces
//
//        ---
//
//# Example
//
//```java
//        interface Utils {
//
//            static void print() {
//                System.out.println("Hello");
//            }
//        }
//```
//
//        Call using:
//
//```java
//        Utils.print();
//```
//
//        ---
//
//# ❌ Cannot Override
//
//        Static methods belong to interface.
//
//        ---
//
//# 🔥 10. Private Methods in Interfaces (Java 9)
//
//        ---
//
//# Why Added?
//
//        Avoid duplicate logic between:
//
//* default methods
//                * static methods
//
//        ---
//
//# Example
//
//```java
//        interface A {
//
//            default void show() {
//                helper();
//            }
//
//            private void helper() {
//                System.out.println("Helper");
//            }
//        }
//```
//
//        ---
//
//# 🔥 11. Functional Interfaces (VERY IMPORTANT)
//
//        Foundation of:
//
//* lambdas
//                * streams
//                * CompletableFuture
//
//                ---
//
//# ✅ Definition
//
//        Interface with:
//
//```text
//        Exactly ONE abstract method
//```
//
//        ---
//
//# Example
//
//```java
//        @FunctionalInterface
//        interface Calculator {
//
//            int add(int a, int b);
//        }
//```
//
//        ---
//
//# 🔥 Can Functional Interface Have Default Methods?
//
//✅ YES
//
//        Only abstract method count matters.
//
//                ---
//
//# Example
//
//```java
//        @FunctionalInterface
//        interface A {
//
//            void show();
//
//            default void log() {}
//        }
//```
//
//        Valid.
//
//                ---
//
//# 🔥 Common Functional Interfaces
//
//                ---
//
//## ✅ Predicate
//
//```java
//        boolean test(T t)
//```
//
//        ---
//
//## ✅ Function
//
//```java
//        R apply(T t)
//```
//
//        ---
//
//## ✅ Consumer
//
//```java
//        void accept(T t)
//```
//
//        ---
//
//## ✅ Supplier
//
//```java
//        T get()
//```
//
//        ---
//
//# 🔥 Why @FunctionalInterface?
//
//        Compiler validation.
//
//        ---
//
//# ❌ Example
//
//```java
//        @FunctionalInterface
//        interface A {
//
//            void a();
//            void b();
//        }
//```
//
//        Compilation error.
//
//        ---
//
//# 🔥 12. Marker Interfaces (VERY IMPORTANT)
//
//        ---
//
//# Definition
//
//        Interface with:
//
//```text
//        NO methods
//```
//
//        ---
//
//# Examples
//
//```java
//                Serializable
//        Cloneable
//                Remote
//```
//
//        ---
//
//# Purpose
//
//        Provide:
//
//```text
//        Metadata/tagging capability
//```
//
//        ---
//
//# Example
//
//```java
//        class User implements Serializable
//```
//
//        JVM/framework understands:
//
//```text
//        Object can be serialized
//```
//
//        ---
//
//# 🔥 Why Marker Interface Instead of Annotation?
//
//        VERY IMPORTANT INTERVIEW QUESTION.
//
//        ---
//
//# Marker Interface Gives
//
//```text
//        Type information
//```
//
//        Annotations do not.
//
//                ---
//
//# Example
//
//```java
//                instanceof Serializable
//```
//
//        possible.
//
//                ---
//
//# 🔥 13. Abstract Method Rules (VERY IMPORTANT)
//
//                ---
//
//# ✅ Abstract Method Cannot Be
//
//        ---
//
//## ❌ private
//
//        Because subclass cannot override.
//
//        ---
//
//## ❌ final
//
//        Because final prevents overriding.
//
//        ---
//
//## ❌ static
//
//        Static methods are not polymorphic.
//
//                ---
//
//# 🔥 14. Abstract Class Rules
//
//                ---
//
//# ✅ Can Have Constructor
//
//        VERY important.
//
//        Used for:
//
//* initialization
//                * common setup
//
//                ---
//
//# Example
//
//```java
//        abstract class A {
//
//            A() {
//                System.out.println("Constructor");
//            }
//        }
//```
//
//        Runs during subclass creation.
//
//        ---
//
//# 🔥 15. Interface Constructor?
//
//❌ NOT possible.
//
//        Why?
//
//                Interfaces have:
//
//```text
//        No instance state
//```
//
//        ---
//
//# 🔥 16. Diamond Problem with Default Methods
//
//        VERY IMPORTANT.
//
//        ---
//
//# Example
//
//```java
//        interface A {
//            default void show() {}
//        }
//
//        interface B {
//            default void show() {}
//        }
//```
//
//        ---
//
//# Child
//
//```java
//        class C implements A, B
//```
//
//❌ Compilation error.
//
//        ---
//
//# Solution
//
//        Must override:
//
//```java
//        @Override
//        public void show() {
//            A.super.show();
//        }
//```
//
//        ---
//
//# 🔥 17. Abstract Class + Interface Together
//
//        VERY common design.
//
//                ---
//
//# Example
//
//```java
//        interface Payment {
//            void pay();
//        }
//
//        abstract class BasePayment
//                implements Payment {
//
//            void validate() {}
//        }
//```
//
//        ---
//
//# Why?
//
//                Interface:
//
//```text
//                contract
//```
//
//        Abstract class:
//
//```text
//        shared implementation
//```
//
//        ---
//
//# 🔥 18. Spring Boot Real Examples
//
//        ---
//
//# Interface Example
//
//```java
//                JpaRepository
//        CrudRepository
//                Runnable
//```
//
//        ---
//
//# Abstract Class Example
//
//```java
//                OncePerRequestFilter
//        AbstractController
//```
//
//        ---
//
//# 🔥 19. Most Asked Trap Questions
//
//        ---
//
//# ❓Can interface have constructor?
//
//❌ No
//
//                ---
//
//# ❓Can abstract class have constructor?
//
//✅ Yes
//
//                ---
//
//# ❓Can abstract class have final method?
//
//✅ Yes
//
//                ---
//
//# ❓Can interface have private methods?
//
//✅ Java 9+
//
//                ---
//
//# ❓Can functional interface have multiple default methods?
//
//✅ Yes
//
//                ---
//
//# ❓Can interface extend multiple interfaces?
//
//✅ Yes
//
//                ---
//
//# ❓Can abstract class implement interface without implementing methods?
//
//✅ Yes if abstract class itself abstract.
//
//        ---
//
//# ❓Can we instantiate abstract class using anonymous class?
//
//✅ YES
//
//```java
//        A obj = new A() {
//            void show() {}
//        };
//```
//
//        VERY famous.
//
//        ---
//
//# ❓Why multiple inheritance not allowed for classes?
//
//                Because of:
//
//```text
//        ambiguity + diamond problem
//```
//
//        ---
//
//# ❓Can interface variables be mutable?
//
//❌ Always:
//
//```text
//        public static final
//```
//
//        ---
//
//# 🔥 20. FAANG-Level Understanding
//
//                ---
//
//# Abstract Class
//
//        Used for:
//
//```text
//        Shared state + partial abstraction
//```
//
//        ---
//
//# Interface
//
//        Used for:
//
//```text
//        Contract/capability + loose coupling
//```
//
//        ---
//
//# Default Methods
//
//        Added for:
//
//```text
//        Backward compatibility
//```
//
//        ---
//
//# Functional Interfaces
//
//        Foundation of:
//
//```text
//        Functional programming in Java
//```
//
//        ---
//
//# Marker Interfaces
//
//        Provide:
//
//```text
//        Type metadata
//```
//
//        ---
//
//# 🚀 Interview-Level Summary
//
//                > “Abstract classes model shared base behavior and state, while interfaces model capabilities/contracts. Java supports multiple inheritance safely through interfaces because behavior conflicts are explicitly resolved. Functional interfaces power Java’s lambda ecosystem, while default methods enable backward-compatible API evolution.”
//
//
//    }
//}
//
//
////# 🔥 Class vs Interface — What to Prefer? (FAANG-Level Understanding)
////
////This is one of the MOST IMPORTANT design questions in:
////
////        * FAANG interviews
////* Atlassian LLD rounds
////* Spring Boot architecture discussions
////
////The real question is NOT:
////
////        ```text id="cvsi1"
////“Which is better?”
////        ```
////
////The real question is:
////
////        ```text id="cvsi2"
////“What relationship are you modeling?”
////        ```
////
////        ---
////
////        # 🔥 Golden Rule
////
////---
////
////        # ✅ Use Interface For
////
////```text id="cvsi3"
////Capability / contract / loose coupling
////```
////
////        ---
////
////        # ✅ Use Abstract/Class For
////
////```text id="cvsi4"
////Shared state + shared implementation
////```
////
////        ---
////
////        # 🔥 Real Difference
////
////---
////
////        # Interface Answers
////
////```text id="cvsi5"
////WHAT can object do?
////        ```
////
////        ---
////
////        # Class/Abstract Class Answers
////
////```text id="cvsi6"
////WHAT object IS?
////        ```
////
////        ---
////
////        # 🔥 Example
////
////---
////
////        # ✅ Interface
////
////```java id="cvsi7"
////interface Flyable {
////    void fly();
////}
////```
////
////Means:
////
////        ```text id="cvsi8"
////CAN fly
////```
////
////        ---
////
////        # ✅ Abstract Class
////
////```java id="cvsi9"
////abstract class Animal {
////    int age;
////}
////```
////
////Means:
////
////        ```text id="cvsi10"
////IS an Animal
////```
////
////        ---
////
////        # 🔥 What FAANG Interviewers Expect
////
////They want:
////
////        * extensible design
////* low coupling
////* maintainability
////* testability
////* SOLID principles
////
////Interfaces help achieve that.
////
////        ---
////
////        # 🔥 Why Interfaces Preferred in Modern Backend
////
////---
////
////        # ✅ Loose Coupling
////
////Example:
////
////        ```java id="cvsi11"
////interface PaymentService {
////    void pay();
////}
////```
////
////Implementations:
////
////        ```java id="cvsi12"
////StripePaymentService
////        PaypalPaymentService
////RazorpayPaymentService
////```
////
////Controller depends on:
////
////        ```text id="cvsi13"
////abstraction
////```
////
////NOT implementation.
////
////        ---
////
////        # 🔥 Spring Boot Uses Interfaces Heavily
////
////Examples:
////
////        * `JpaRepository`
////        * `CrudRepository`
////        * `Runnable`
////        * `Comparator`
////
////Because interfaces allow:
////
////        ```text id="cvsi14"
////plug-and-play architecture
////```
////
////        ---
////
////        # 🔥 Why Interfaces Improve Testing
////
////VERY IMPORTANT.
////
////        ---
////
////        # Without Interface
////
////```java id="cvsi15"
////class OrderService {
////
////    private StripePaymentService payment;
////}
////```
////
////Hard to mock.
////
////---
////
////        # With Interface
////
////```java id="cvsi16"
////class OrderService {
////
////    private PaymentService payment;
////}
////```
////
////Now easy:
////
////        ```text id="cvsi17"
////Mockito mock
////```
////
////        ---
////
////        # 🔥 Use Abstract Class When You Need Shared Code
////
////---
////
////        # Example
////
////```java id="cvsi18"
////abstract class NotificationService {
////
////    void log() {
////        System.out.println("logging");
////    }
////
////    abstract void send();
////}
////```
////
////Shared logic:
////
////        ```text id="cvsi19"
////log()
////```
////
////used by all subclasses.
////
////        ---
////
////        # 🔥 Interface Cannot Hold Object State
////
////---
////
////        # ❌ Interface
////
////```java id="cvsi20"
////interface A {
////    int x = 10;
////}
////```
////
////Variable becomes:
////
////        ```text id="cvsi21"
////public static final
////```
////
////No mutable state.
////
////---
////
////        # ✅ Abstract Class
////
////```java id="cvsi22"
////abstract class A {
////    int x;
////}
////```
////
////State allowed.
////
////        ---
////
////        # 🔥 Multiple Inheritance Advantage
////
////Interfaces support:
////
////        ```text id="cvsi23"
////multiple inheritance
////```
////
////        ---
////
////        # Example
////
////```java id="cvsi24"
////class Robot implements Walkable, Flyable
////```
////
////Classes cannot do this.
////
////        ---
////
////        # 🔥 Modern Java Philosophy
////
////Java increasingly prefers:
////
////        ```text id="cvsi25"
////composition + interfaces
////```
////
////over:
////
////        ```text id="cvsi26"
////deep inheritance hierarchies
////```
////
////        ---
////
////        # 🔥 Why Deep Inheritance Bad
////
////Problems:
////
////        * tight coupling
////* fragile base class
////* difficult debugging
////* hard modification
////
////---
////
////        # 🔥 Interface + Composition = Better Design
////
////VERY IMPORTANT.
////
////        ---
////
////        # Example
////
////Instead of:
////
////        ```text id="cvsi27"
////Animal → Bird → FlyingBird → Eagle
////```
////
////Prefer:
////
////        ```java id="cvsi28"
////class Eagle implements Flyable
////```
////
////Cleaner.
////
////---
////
////        # 🔥 FAANG-Level Design Principle
////
////---
////
////        # “Program to Interface, Not Implementation”
////
////VERY famous principle.
////
////---
////
////        # ❌ Bad
////
////```java id="cvsi29"
////ArrayList list = new ArrayList();
////```
////
////        ---
////
////        # ✅ Better
////
////```java id="cvsi30"
////List list = new ArrayList();
////```
////
////Why?
////
////Implementation can change easily.
////
////        ---
////
////        # 🔥 Performance Consideration
////
////Historically:
////
////        ```text id="cvsi31"
////interfaces slightly slower
////```
////
////because of dynamic dispatch.
////
////Modern JVM:
////
////        ```text id="cvsi32"
////JIT optimization removes most difference
////```
////
////So design matters more.
////
////        ---
////
////        # 🔥 When NOT to Use Interface
////
////Use abstract class if:
////
////        * common state needed
////* constructors needed
////* partial implementation needed
////* protected methods needed
////
////---
////
////        # 🔥 Decision Tree (VERY IMPORTANT)
////
////---
////
////        # ✅ Choose Interface If
////
////You need:
////
////        * contract
////* capability
////* multiple inheritance
////* loose coupling
////* strategy pattern
////* pluggable architecture
////
////---
////
////        # ✅ Choose Abstract Class If
////
////You need:
////
////        * shared state
////* common implementation
////* constructor logic
////* lifecycle control
////
////---
////
////        # 🔥 Real Spring Boot Example
////
////---
////
////        # Interface
////
////```java id="cvsi33"
////interface PaymentGateway {
////    void pay();
////}
////```
////
////        ---
////
////        # Implementations
////
////```java id="cvsi34"
////class StripeGateway
////class PaypalGateway
////```
////
////        ---
////
////        # Service Depends on Interface
////
////```java id="cvsi35"
////@Service
////class OrderService {
////
////    private final PaymentGateway gateway;
////}
////```
////
////Spring injects implementation dynamically.
////
////THIS is professional backend design.
////
////---
////
////        # 🔥 FAANG Trap Questions
////
////---
////
////        # ❓Can interface replace abstract class fully?
////
////        ❌ No
////
////Interfaces cannot:
////
////        * maintain instance state
////* have constructors
////
////---
////
////        # ❓Can abstract class implement interface?
////
////        ✅ Yes
////
////Very common.
////
////        ---
////
////        # ❓Can interface extend class?
////
////        ❌ No
////
////---
////
////        # ❓Can class implement multiple interfaces?
////
////        ✅ Yes
////
////---
////
////        # ❓Why Spring prefers interfaces?
////
////        * loose coupling
////* AOP proxies
////* easier testing
////* extensibility
////
////---
////
////        # ❓Why composition preferred over inheritance?
////
////Because inheritance tightly couples classes.
////
////---
////
////        # 🚀 Final FAANG-Level Answer
////
////> “Prefer interfaces for contracts, extensibility, loose coupling, and testability. Prefer abstract classes when shared state or partial implementation is required. Modern backend systems like Spring Boot heavily favor interface-driven design combined with composition because it improves maintainability, flexibility, and scalability.”
