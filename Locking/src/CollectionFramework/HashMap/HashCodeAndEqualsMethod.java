package CollectionFramework.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//3rd
public class HashCodeAndEqualsMethod {
    static void main() {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1);

        map.put(p1, "Engineer");//hashcode -->index
        map.put(p2, "Designer");//hashcode -->index
        map.put(p3, "Manager");//hashcode --> index here replace will not happen because hashcode will be different because, we have used new keyword while creating object which means those object are located on different address

        System.out.println("HashMap size: " + map.size());
        System.out.println("Value for p1: " + map.get(p1));
        System.out.println("Value for p3: " + map.get(p3));
        System.out.println(p1);
        //vvvvvv imp: in future whenever you create custom class you should have created hash code method and equals methods
        // Now the size will be 2
        // time complexity  |  average case  |  worst case |  Explanation
        // put(key, value) :     O(1)           O(log n)       Average: direct bucket access, worst case: bucket converts to red black tree
        // get(key)        :     O(1)           O(log n)       Average: direct bucket access, worst case: when searching within a treeified bucket
        // remove(key)     :     O(1)           O(log n)       Average: direct bucket access, worst case: when removing from a treeified bucket
        // containsKey(key):     O(1)           O(log n)       Average: direct bucket access, worst case: when searching within a treeified bucket
        // containsValue(v):     O(N)           O(N)           both average and worst case are linear time since it may need to traverse all entries
        // size()          :     O(1)           O(1)           both average and worst case are constant time as the size is maintained as a separate field



        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Sham", 90); //hashcode1 --> index1
        map1.put("Neela", 50); //hashcode2 --> index2
        map1.put("Sham", 95);//hashcode1 --> index1 -->equals() --> replace()
    }
}

class Person{
    private String name;
    private int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    // we will let map know that p1 and p3 are the same person


    @Override
    public boolean equals(Object obj) {
        if(this == obj){ //same object chaking
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Person other = (Person) obj;
        return id == other.getId() && Objects.equals(name, other.name); //to handle the null handling exception we used Objects class
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name; //what to print  System.out.println(p1);
    }
}
