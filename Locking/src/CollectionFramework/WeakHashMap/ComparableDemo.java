package CollectionFramework.WeakHashMap;

import java.util.ArrayList;
import java.util.List;
//Comparator we give when we have to given custom logic
//Comparable: for natural ordering we let class know using comparable

public class ComparableDemo {
    static void main() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("charlie", 4.5));
        list.add(new Student("neha", 2.9));
        list.add(new Student("ram", 7.8));
        list.add(new Student("sham", 8.9));
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
//        list.sort(null); //this will throw error, for natural ordering we let class know using comparable
        numbers.sort(null); //this will use natural ordering

        list.sort(null);
        System.out.println(list);
        System.out.println(numbers);
    }
}
class Student implements Comparable<Student>{
    private String name;
    private double gpa;

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public String getName(){return name;}

    public double getGpa(){return gpa;}

    //we can only right logic on one field, for natural sorting
    @Override //this works as obj1.compareTo(obj2), in comparator we have compare(obj1, obj2)
    public int compareTo(Student o) {
//        return Double.compare(o.getGpa(), this.getGpa()); //descending order
        return Double.compare( this.getGpa(), o.getGpa()); //ascending order
    }
}
