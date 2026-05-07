package Revision.OOPsFundamentals1;

public class OOPsPrinciples {
    static void main() {
//        If you say textbook definitions in an Atlassian interview, it won’t land. They expect **clean explanations + practical system thinking (Spring Boot / backend)**.
//
//        Let’s upgrade each OOP principle into **Atlassian-level answers with real examples + what to actually say**.
//
//        ---
//
//# 🔥 1. ABSTRACTION (Atlassian-Level Answer)
//
//## 🧠 What to Say (Concise + Strong)
//
//                > “Abstraction means exposing only necessary operations while hiding internal implementation details. In Spring Boot, we use interfaces and service layers to decouple controllers from business logic.”
//
//        ---
//
//## 🟢 Real Spring Boot Example
//
//```java
//        public interface PaymentService {
//            void processPayment(double amount);
//        }
//```
//
//```java
//        @Service
//        public class StripePaymentService implements PaymentService {
//            public void processPayment(double amount) {
//                // Stripe API call
//            }
//        }
//```
//
//```java
//        @RestController
//        public class PaymentController {
//
//            private final PaymentService paymentService;
//
//            public PaymentController(PaymentService paymentService) {
//                this.paymentService = paymentService;
//            }
//
//            @PostMapping("/pay")
//            public void pay() {
//                paymentService.processPayment(100);
//            }
//        }
//```
//
//        ---
//
//## 🧠 What’s happening?
//
//* Controller doesn’t know implementation
//                * Can switch Stripe → Razorpay without changing controller
//
//👉 That’s abstraction
//
//        ---
//
//## 💡 Atlassian Insight
//
//* Enables **plug-and-play architecture**
//                * Critical for **microservices & API design**
//
//                ---
//
//# 🔥 2. ENCAPSULATION (Atlassian-Level Answer)
//
//## 🧠 What to Say
//
//                > “Encapsulation is binding data and behavior together while restricting direct access. In Spring Boot, we use private fields with controlled access via services or DTOs to ensure validation and data integrity.”
//
//        ---
//
//## 🟢 Real Example (DTO + Validation)
//
//```java
//        public class User {
//
//            private String email;
//
//            public void setEmail(String email) {
//                if (!email.contains("@")) {
//                    throw new IllegalArgumentException("Invalid email");
//                }
//                this.email = email;
//            }
//
//            public String getEmail() {
//                return email;
//            }
//        }
//```
//
//        ---
//
//## 🧠 Real Backend Insight
//
//👉 You never expose entity directly:
//
//```java
//        @Entity // ❌ avoid exposing directly
//        class UserEntity {}
//```
//
//👉 Use DTO:
//
//```java
//        class UserDTO {}
//```
//
//        ---
//
//## 💡 Atlassian Insight
//
//* Prevents invalid data
//                * Improves API stability
//* Critical for **security + validation layers**
//
//                ---
//
//# 🔥 3. INHERITANCE (Atlassian-Level Answer)
//
//## 🧠 What to Say
//
//                > “Inheritance allows code reuse through IS-A relationships. In Spring Boot, it is commonly used in base entities, exception handling, and shared configurations.”
//
//        ---
//
//## 🟢 Real Example (Base Entity)
//
//```java
//        @MappedSuperclass
//        public abstract class BaseEntity {
//            @Id
//            @GeneratedValue
//            private Long id;
//
//            private LocalDateTime createdAt;
//        }
//```
//
//```java
//        @Entity
//        public class User extends BaseEntity {
//            private String name;
//        }
//```
//
//        ---
//
//## 🧠 What’s happening?
//
//* Shared fields reused
//                * Avoid duplication
//
//                ---
//
//## 💡 Atlassian Insight
//
//👉 But important:
//
//> “We avoid deep inheritance hierarchies and prefer composition in large systems.”
//
//        ---
//
//## 🟢 Another Real Example (Exception Handling)
//
//```java
//        class BaseException extends RuntimeException {}
//
//        class UserNotFoundException extends BaseException {}
//```
//
//        ---
//
//# 🔥 4. POLYMORPHISM (Atlassian-Level Answer)
//
//## 🧠 What to Say
//
//                > “Polymorphism allows one interface to have multiple implementations. In Spring Boot, it’s heavily used with dependency injection where the same interface can have multiple implementations selected at runtime.”
//
//        ---
//
//## 🟢 Real Example
//
//```java
//        public interface NotificationService {
//            void send(String message);
//        }
//```
//
//```java
//        @Service
//        public class EmailService implements NotificationService {
//            public void send(String message) {
//                System.out.println("Email: " + message);
//            }
//        }
//```
//
//```java
//        @Service
//        public class SMSService implements NotificationService {
//            public void send(String message) {
//                System.out.println("SMS: " + message);
//            }
//        }
//```
//
//        ---
//
//## 🟢 Usage
//
//```java
//        @Autowired
//        @Qualifier("emailService")
//        private NotificationService service;
//```
//
//        ---
//
//## 🧠 What’s happening?
//
//👉 Same interface
//👉 Different behavior at runtime
//
//        ---
//
//## 💡 Atlassian Insight
//
//* Used in **strategy pattern**
//* Helps in **feature toggles / A-B testing**
//
//                ---
//
//# 🔥 FAANG / Atlassian-Level Comparison Summary
//
//| Principle     | Real Backend Use                |
//| ------------- | ------------------------------- |
//                | Abstraction   | Interfaces + service layer      |
//                | Encapsulation | DTOs + validation               |
//                | Inheritance   | Base entities / exceptions      |
//                | Polymorphism  | Multiple implementations via DI |
//
//                ---
//
//# 🔥 REAL INTERVIEW GOOGLY QUESTIONS
//
//        ---
//
//## ❓1. Why not use inheritance everywhere?
//
//👉 Answer:
//
//> “Inheritance creates tight coupling. In large systems like Atlassian products, we prefer composition for flexibility and scalability.”
//
//        ---
//
//## ❓2. Where is polymorphism used in Spring internally?
//
//👉 Answer:
//
//* Dependency Injection
//* Bean resolution
//* AOP proxies
//
//        ---
//
//## ❓3. How does Spring achieve abstraction?
//
//👉 Answer:
//
//* Interfaces
//                * IOC container hides implementation details
//
//        ---
//
//## ❓4. Can you replace inheritance with composition?
//
//👉 Answer:
//
//> “Yes, and in most production systems we prefer composition because it reduces coupling and improves testability.”
//
//        ---
//
//## ❓5. Real-world scenario question
//
//👉 “Design a payment system”
//
//        Expected:
//
//* Abstraction → PaymentService interface
//* Polymorphism → Razorpay, Stripe
//                * Encapsulation → PaymentRequest DTO
//* Inheritance → BaseEntity or BaseException
//
//                ---
//
//# 🚀 30-Second Killer Answer (Use This)
//
//> “In Spring Boot, abstraction is achieved using interfaces and service layers to hide implementation details. Encapsulation ensures data safety through DTOs and controlled access. Inheritance is used for code reuse like base entities and exception hierarchies, but kept minimal to avoid tight coupling. Polymorphism is widely used via dependency injection, allowing multiple implementations of the same interface to be selected at runtime, enabling flexible and scalable system design.”
//
//        ---
//
//# 🧠 Final Insight (This impresses Atlassian)
//
//👉 Don’t just say definitions
//👉 Always connect to:
//
//* Scalability
//                * Maintainability
//                * Loose coupling
//                * Microservices design
//
//                ---
//
//                If you want next level:
//
//👉 I can simulate a **real Atlassian backend interview round** and ask you follow-ups on these answers (very powerful practice).

    }
}
