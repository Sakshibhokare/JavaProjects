package CollectionFramework.WeakHashMap;

import java.lang.ref.WeakReference;

public class GarbageCollection {
    static void main() {
        //this allocates memory in heap memory
        //JVM can see there is no reference for this memory, then JVM will free up that memory by deleting
        Phone myPhone = new Phone("Apple", "16 pro max"); //this is a strong reference
        System.out.println(myPhone);
        myPhone = null; //now there is no pointer to the object we created earlier
        System.out.println(myPhone);


        //weak reference, here we let JVM know that this is not required if this is not getting used anywhere we can remove that
        WeakReference<Phone> newPhone = new WeakReference<>(new Phone("Apple", "17 pro max"));
        System.out.println(newPhone.get());
        System.gc();
        try {
            Thread.sleep(10000);
        }catch (Exception ignored){

        }
        System.out.println("removed: " +newPhone.get());
    }
}

class Phone{
    String brand;
    String model;

    public Phone(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}