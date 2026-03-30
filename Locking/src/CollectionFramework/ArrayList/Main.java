package CollectionFramework.ArrayList;

import java.lang.reflect.Field;
import java.util.*;

public class Main {
    static void main() throws IllegalAccessException, NoSuchFieldException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //add
        arrayList.add(1);
        arrayList.add(20);
        arrayList.add(40);

        //get
        System.out.println(arrayList.get(2));

        //size
        System.out.println(arrayList.size());

        //iterate
        for(int i=0; i<arrayList.size(); i++){
            System.out.println("*"+arrayList.get(i));
        }
        //this will be a element not pointer
        for(int x: arrayList){
            System.out.println("**"+x);
        }

        //if present
        System.out.println(arrayList.contains(55));

        //remove
        arrayList.remove(2);

        System.out.println(arrayList.size());

        //add element in the middle
        arrayList.add(1, 50);
        System.out.println("first index " + arrayList.get(1));

        //replace element at specific location
        arrayList.set(1, 60);
        System.out.println("first index " + arrayList.get(1));

        for(int x: arrayList){
            System.out.println(x);
        }

//        Internal working
//        Unlike a regular array, which has a fixed size, an ArrayList can grow and shrink as elements are added or removed. this dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array

//    vv imp: When you create an arraylist it has an initial capacity (default is 10). the capacity refers to the size of the internal array that can hold elements before needing to resize.

//    Internal adding element:
//        check capacity: check if resize needed
//        Resize is needed: 1.5 times the current capacity -> takes element from old array and put into new array which is incremented
//        Add the element: the new element is added


//        Removing Element
//        check Bounds: check if index is within the valid range
//        Remove the Element: element is removed and all element are shifted one position to the left to fill the gap
//        Reduce size: The size is decremented by 1
//        ArrayList<Integer> list = new ArrayList<>(1000); //just decide the capacity not the size
//        list.add(1); //if not written this, code will give runtime error,
//        System.out.println("what is the size: " + list.size() ); //Interview questions
//        System.out.println("what is the first element: " + list.getFirst());
//
//        Can we get capacity? Yes
//        using reflection
//        ArrayList<Integer> arr = new ArrayList<>(2);
//        arr.add(2);
//        arr.add(3);
//
//        Field field = ArrayList.class.getDeclaredField("elementData");
//        field.setAccessible(true);
//
//        Object[] elementData = (Object[]) field.get(arr); // always fetch fresh reference
//        System.out.println("Size: " + arr.size() + ", Capacity: " + elementData.length);
//
//        arr.add(4);
//        System.out.println("ArrayList capacity: " + elementData.length);

//        to run above we need to add VM options
//        Capacity increases 11 -> 16
//        Even after removing element size id not shrinking
//        using arr.trimToSize(); //this updates capacity according to size


//vvv imp: ->
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        //we can not write ArrayList here, because we are accessing parent List class
        List<String> list1 = Arrays.asList("Monday", "Tuesday");
        System.out.println(list1.getClass().getName());
//        list1.add("wed"); // we can not add anything here, because this returns fixed size, we can not add remove element only replace, this is fixed

        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list2 = Arrays.asList(array);
        System.out.println(list2.getClass().getName());

//      here even you can not add remove or replace
        List<Integer> list3 = List.of(1, 2, 3, 4, 5, 6);

        List<String>list4 = new ArrayList<>();
        list4.add("mango");
        System.out.println(list4);



        //we can add collection as well
        list.addAll(list2);
        System.out.println(list);


        //if we want to remove element by value not by index then we have to pass the object
//        list.remove(Integer.valueOf(1)); value 1 element will be removed
        list.remove("Banana");



        List<Integer> listi = new ArrayList<>();
        listi.add(1);
        listi.add(2);
        listi.add(3);
//        Converting list to array
        Object[] array2 = list.toArray();
        listi.toArray(new Integer[0]); //by passing first element we let them know what type of array we want

        Collections.sort(list);
        System.out.println(list);



//        Time Complexity
//        get -> O(1)
//        adding O(n)
//        Removing O(n)
//        Iteration O(n)
    }
}
