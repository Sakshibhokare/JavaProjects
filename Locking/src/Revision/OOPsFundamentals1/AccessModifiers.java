package Revision.OOPsFundamentals1;

/*
===========================================================
TOPIC: Access Modifiers
===========================================================

Java has 4 access modifiers:

1. private        → only inside SAME class
2. default        → (no keyword) same package only
3. protected      → same package + subclasses (even in other package)
4. public         → everywhere

===========================================================
ACCESS LEVEL TABLE (VERY IMPORTANT)
===========================================================

Modifier     | Same Class | Same Package | Subclass (diff pkg) | Other pkg
-------------|------------|--------------|----------------------|-----------
private      | ✅          | ❌            | ❌                    | ❌
default      | ✅          | ✅            | ❌                    | ❌
protected    | ✅          | ✅            | ✅                    | ❌
public       | ✅          | ✅            | ✅                    | ✅

===========================================================
*/

public class AccessModifiers {

    public static void main(String[] args) {

        Demo demo = new Demo();

        // ===============================
        // ACCESSING MEMBERS
        // ===============================

        // demo.privateVar; ❌ ERROR (only inside class)

        System.out.println(demo.defaultVar);   // ✅ same package
        System.out.println(demo.protectedVar); // ✅ same package
        System.out.println(demo.publicVar);    // ✅ everywhere

        demo.publicMethod();   // ✅
        demo.protectedMethod();// ✅
        demo.defaultMethod();  // ✅
        // demo.privateMethod(); ❌
    }
}

/*
===========================================================
BASE CLASS
===========================================================
*/

class Demo {

    // ===============================
    // VARIABLES
    // ===============================

    private int privateVar = 10;      // only inside this class
    int defaultVar = 20;             // default (package-private)
    protected int protectedVar = 30; // package + subclass
    public int publicVar = 40;       // everywhere

    // ===============================
    // METHODS
    // ===============================

    private void privateMethod() {
        System.out.println("Private Method");
    }

    void defaultMethod() {
        System.out.println("Default Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    public void publicMethod() {
        System.out.println("Public Method");
    }

    // ===============================
    // INTERNAL ACCESS (ALL WORKS)
    // ===============================

    void testInsideClass() {
        // inside same class → everything accessible
        System.out.println(privateVar);
        privateMethod();
    }
}

/*
===========================================================
SUBCLASS (Same Package)
===========================================================
*/

class ChildSamePackage extends Demo {

    void test() {

        // privateVar ❌ NOT accessible

        System.out.println(defaultVar);   // ✅
        System.out.println(protectedVar); // ✅
        System.out.println(publicVar);    // ✅
    }
}

/*
===========================================================
SUBCLASS (Different Package) - CONCEPTUAL
===========================================================

package anotherPackage;

import Revision.OOPsFundamentals1.Demo;

class ChildDifferentPackage extends Demo {

    void test() {

        // privateVar ❌
        // defaultVar ❌ (different package)

        System.out.println(protectedVar); // ✅ ONLY via inheritance
        System.out.println(publicVar);    // ✅
    }
}

IMPORTANT:
protected works in different package ONLY through inheritance
NOT via object

Example:
Demo d = new Demo();
d.protectedVar ❌ (in different package)
===========================================================
*/

//🚨 MOST IMPORTANT INTERVIEW TRICK
//❓ protected in different package
//Demo d = new Demo();
//d.protectedVar ❌
//
//BUT:
//
//class Child extends Demo {
//    protectedVar ✅
//}
//
//👉 ONLY through inheritance