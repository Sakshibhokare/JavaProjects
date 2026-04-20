package Revision.OOPsFundamentals1;

/*
===========================================================
TOPIC: Constructors (Default, Parameterized, Copy)
===========================================================

A constructor is a special method used to initialize objects.

Rules:
1. Same name as class
2. No return type (not even void)
3. Called automatically when object is created
4. Can be overloaded
===========================================================
*/

public class ConstructorRev {

    public static void main(String[] args) {

        // ===============================
        // 1. DEFAULT CONSTRUCTOR
        // ===============================
        DemoStudent s1 = new DemoStudent();
        System.out.println(s1);

        // ===============================
        // 2. PARAMETERIZED CONSTRUCTOR
        // ===============================
        DemoStudent s2 = new DemoStudent(2, "Rahul");
        System.out.println(s2);

        // ===============================
        // 3. COPY CONSTRUCTOR
        // ===============================
        DemoStudent s3 = new DemoStudent(s2);
        System.out.println(s3);

        // ===============================
        // MODIFY ORIGINAL OBJECT
        // ===============================
        s2.setName("Changed Rahul");

        System.out.println("After modifying s2:");
        System.out.println(s2); // changed object
        System.out.println(s3); // copied object remains unchanged
    }
}

/*
===========================================================
CLASS WITH ALL TYPES OF CONSTRUCTORS
===========================================================
*/

class DemoStudent {

    // private fields → encapsulation
    private int id;
    private String name;

    // ===============================
    // 1. DEFAULT CONSTRUCTOR
    // ===============================
    DemoStudent() {
        // constructor chaining
        this(0, "Default Name");
        System.out.println("Default Constructor Called");
    }

    // ===============================
    // 2. PARAMETERIZED CONSTRUCTOR
    // ===============================
    DemoStudent(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor Called");
    }

    // ===============================
    // 3. COPY CONSTRUCTOR
    // ===============================
    DemoStudent(DemoStudent other) {

        // null safety check
        if (other != null) {
            this.id = other.id;
            this.name = other.name;
        }

        System.out.println("Copy Constructor Called");
    }

    // ===============================
    // SETTER METHOD
    // ===============================
    public void setName(String name) {
        this.name = name;
    }

    // ===============================
    // GETTER METHODS
    // ===============================
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ===============================
    // toString METHOD
    // ===============================
    @Override
    public String toString() {
        return "DemoStudent{id=" + id + ", name='" + name + "'}";
    }
}

//❓ Can constructor be private?
//
//        👉 Yes (Singleton pattern)
//Singleton pattern ensures that only ONE object of a class is created and provides a global access point to it.
//Why use it?
//Database connection
//Logger
//Configuration manager
//Caching system


//❓ Can constructor be overloaded?
//
//        👉 Yes ✅
//“Constructors cannot be static because they are used to initialize objects, and static belongs to class—not object.”


// ❓ Can constructor be static?
//
//        👉 ❌ No
//
//❓ What if no constructor is written?
//
//        👉 Java provides default one