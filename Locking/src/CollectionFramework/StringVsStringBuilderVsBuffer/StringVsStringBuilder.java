package CollectionFramework.StringVsStringBuilderVsBuffer;

public class StringVsStringBuilder {
    static void main() throws InterruptedException {
        //strings are immutable we can not modify them, stores in string pool
        //string is thread safe
        String str1 = "Hello";
        str1.concat("World");// this is actually creating a new string
        String str2 = str1.concat(" Wolrd");
        System.out.println(str1);
        System.out.println(str2);

        String result = "";
        for (int i =0; i<1000; i++){ //this will create 1000 new strings
            result+="world";
        }
        System.out.println(result);



        //for solving this issue we uses string builder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" world").append(" !").reverse();
        sb.insert(1, "Java");
        sb.replace(1,3, "worlds");
        sb.delete(1,4);
        sb.charAt(0);
        sb.length();
        sb.substring(1, 4);
        System.out.println(sb);

        //string builder: char array with default capacity 16 when array full it doubles the size, and put into new string with old values
        //mutable
        //method chaining
        //not thread safe
        //good performance



        //String Buffer is thread safe
        // slow in performance due to thread safety
        StringBuffer sb1 = new StringBuffer();

        Task t1 = new Task(sb1);
        Task t2 = new Task(sb1);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Length: " +sb1.length());

    }
}

class Task extends Thread{
    private StringBuffer sb;
    public Task(StringBuffer sb){
        this.sb=sb;
    }
    @Override
    public void  run(){
        for(int i=0; i<1000; i++){
            sb.append("a");
        }
    }
}
