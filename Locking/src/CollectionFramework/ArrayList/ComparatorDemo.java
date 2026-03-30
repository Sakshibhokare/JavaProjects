package CollectionFramework.ArrayList;

import java.util.*;
//but if we want custom sort then we can use Comparator, for using comparator interface then we have to implement the class or create lambda expression
//5 3 -> ascending -> return o1 - o2 to return positive
//3 5 ->

//"ok" "bye" -> o2.length()-o1.length()  positive -> descending order
//           -> o1.length()-o2.length()  negative -> ascending order

// Custom comparator for integers (ascending)
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2; // ascending order
    }
}

// Comparator for string length
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(0);

        // Sort integers
        list.sort(new MyComparator());
        System.out.println("Sorted integers: " + list);

        // Sort strings by length
        List<String> words = Arrays.asList("banana", "apple", "date");

        words.sort(new StringLengthComparator());
        System.out.println("Sorted by length: " + words);

        //using lambda expression
        words.sort((a, b)-> b.length() - a.length());
        System.out.println("Descending Order: " + words);

        list.sort((a,b)-> b - a);
        System.out.println("Descending int: " +  list);


//        using class student/ object
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 8.9));
        students.add(new Student("sakshi", 9.9));
        students.add(new Student("pranay", 8.9));
        students.add(new Student("siddhi", 5.6));

//        students.sort(null); we can not give null, because there is no natural ordering

//        students.sort((o1, o2)-> (int) (o2.getGpa() - o1.getGpa()));
       //when we caste into int we can not check points, so now we can check point from below
//        students.sort((o1, o2)->{
//            if(o2.getGpa()-o1.getGpa() >0){
//                return 1;
//            }else if(o2.getGpa() - o1.getGpa() <0){
//                return -1;
//            }else{
//             return o1.getName().compareTo(o2.getName());
//                return 0;
//            }
//        });

//        we have one more way to do this, it is in java 8, |
//        default it is in ascending order, for descending use .reversed()
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed();
         students.sort(comparator);


//         now we can compare by name as well
        Comparator<Student> compareWithName = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); //Student::getName this is called method signature
        students.sort(compareWithName);

        for (Student s: students){
            System.out.println(s.getName() + ":" + s.getGpa());
        }

        Collections.sort(students, comparator);
    }
}

class Student{
    private String name;
    private double gpa;

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName(){return name;}

    public double getGpa(){return gpa;}
}
