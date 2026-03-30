package CollectionFramework.Stack;
//because the stack is synchronized locking happens here, which affects the performance
//to solve this issue CopyOnWriteArrayList is introduced

//what happens here:
//"Copy on write " means that whenever a write operation
//like adding or removing an element
//instead of directly modifying the existing list
//a new copy of the list is created and the modification is applied to that copy
//This ensures that other threads reading the list while it's being modified are unaffected

//Read Operations:Fast and direct, since they happen ona a stable list without interference from modification
//write operations: A new copy of the list is created for every modification.
//                  The reference to the list is then updated so that subsequent reads use this new list.

import CollectionFramework.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//for example: Notepad
public class CopyOnWriteArrayListDemo {
    static void main() {
        //this is only useful when read operations are more than write, because we are creating new copy every time
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        //this is single threading
//        List<String> shoppingList = new ArrayList<>(); //this will throw exception because list does not allow to modify while reading
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Sugar");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List: " + shoppingList);

        for(String item: shoppingList){
            System.out.println(item);
            //try to modify the list while reading
            if(item.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added Butter while reading.");
            }
        }
        //old = new
        System.out.println("Updated shopping List: " + shoppingList);




    }
}
