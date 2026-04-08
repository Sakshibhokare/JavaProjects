package CollectionFramework.WeakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashedMapDemo {
    static void main() {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
//        imageCache.put("img1", new Image("Image 1"));
//        imageCache.put("img2", new Image("Image 2"));
//        System.out.println(imageCache);
//        System.gc(); //since after this, we will be waiting for few seconds then, JSM will get to know that we have not use so we can remove that
        //but this is not getting removed why?
        //An entry in a weakHashMap will automatically be removed when its key is no longer in ordinary use
        //but since our key is String, which are string literals which is stored in string pool, because of this it becomes strong reference
        //java keeps that string in string pool till the jvm completes program, it uses same memory, if i use img2 1000 times it will be reference to the same memory location in string pool
        //we need to make sure that keys will be garbage collected, need tp create non literal keys


        WeakHashMap<String, Image> imageCache2 = new WeakHashMap<>();
//        String key1 = new String("img1");
//        String key2 = new String("img2");
        imageCache2.put(new String("img1"), new Image("Image 1")); //using this no need to mark null
        imageCache2.put(new String("img2"), new Image("image 2"));

        loadCache(imageCache2);
        System.out.println(imageCache2);


        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache after running (some entries may cleared): " + imageCache);
    }

    private static void simulateApplicationRunning(){
        try{
            System.out.println("Simulating application running..........");
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //even after taking strong reference we are not required to make them null, because the scope is limited, so jsm will automatically clear that from memory
    public static void loadCache(Map<String, Image> imageCache){
        String k1 = new String("imgOne");
        String k2 = new String("imgTwo");
        imageCache.put(k1, new Image("image 1"));
        imageCache.put(k2, new Image("image 2"));
    }
}

class Image{
    private String name;
    public Image(String name){
        this.name= name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
