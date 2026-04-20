package Revision.OOPsFundamentals1;

/*
===========================================================
TOPIC: Classes, Objects, Fields, Methods (CORE OOP)
===========================================================

Think of:

Class  → Blueprint (Design)
Object → Real instance created from class
Fields → Variables inside class (state/data)
Methods → Functions inside class (behavior)
===========================================================
*/

public class ClassesObjectsFieldsMethods {

    public static void main(String[] args) {

        // ===============================
        // OBJECT CREATION
        // ===============================

        // Syntax:
        // ClassName objectName = new ClassName();

        Student s1 = new Student(1, "Sakshi"); // object 1
        Student s2 = new Student(2, "Rahul");  // object 2

        // ===============================
        // ACCESSING FIELDS
        // ===============================

        System.out.println(s1.id);     // accessing field
        System.out.println(s1.name);

        // ===============================
        // CALLING METHODS
        // ===============================

        s1.study();   // method call
        s2.study();

        // ===============================
        // CHANGING STATE (FIELDS)
        // ===============================

        s1.name = "Updated Sakshi";  // modifying field
        System.out.println(s1.name);

        // ===============================
        // STATIC METHOD CALL
        // ===============================

        Student.schoolName(); // static method (class-level)
        Student.count=90;

    }
}

/*
===========================================================
CLASS DEFINITION
===========================================================
*/

class Student {

    // ===============================
    // FIELDS (Instance Variables)
    // ===============================

    int id;        // each object has its own copy
    String name;

    // ===============================
    // STATIC FIELD (Class Variable)
    // ===============================

    static String school = "ABC School";
    static int count =0;
    // Shared across ALL objects

    // ===============================
    // CONSTRUCTOR
    // ===============================

    // Special method used to initialize object
    Student(int id, String name) {
        this.id = id;     // 'this' refers to current object
        this.name = name;
    }

    // ===============================
    // INSTANCE METHOD
    // ===============================

    void study() {
        // Access instance variables directly
        System.out.println(name + " is studying");
    }

    // ===============================
    // STATIC METHOD
    // ===============================

    static void schoolName() {
        // Can only access static variables directly
        System.out.println("School: " + school);
    }
}

//Object : Stored in heap memory
//        | Feature    | Instance        | Static         |
//        | ---------- | --------------- | -------------- |
//        | Belongs to | Object          | Class          |
//        | Memory     | Per object      | One copy       |
//        | Access     | object.method() | Class.method() |
