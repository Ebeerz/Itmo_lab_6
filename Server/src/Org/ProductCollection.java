package Org;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class ProductCollection implements Serializable {
    private static TreeSet<Product> collection = new TreeSet<Product>();
    private static LocalDateTime time = LocalDateTime.now();
    private static String fileName;

    public static void setFileName(String fileName){
        ProductCollection.fileName = fileName;
    }

    public static String getFileName(){
        return ProductCollection.fileName;
    }

    public static LocalDateTime getTime() {
        return time;
    }

    public static void setTime(LocalDateTime time) {
        ProductCollection.time = time;
    }

    public static TreeSet<Product> getCollection(){
        return collection;
    }

    public static void setCollection(TreeSet<Product> collection){
        ProductCollection.collection = collection;
    }
    public static TreeSet<Product> getCollection(TreeSet<Product> collection){
        return collection;
    }

    public static void clear(){
        collection.clear();
    }

    public static void add(Product product){
        collection.add(product);
    }

    public static int getSize(){
        return collection.size();
    }

    public static Class<? extends Collection> getType(){
        return collection.getClass();
    }

    public static long getFreeId(){
        ArrayList<Long> busyId = new ArrayList<>();
        Iterator<Product> it = collection.iterator();
        while(it.hasNext()){
            busyId.add(it.next().getId());
        }
        for (long id = 1; id <= busyId.size() + 1; id ++){
            if (!busyId.contains(id)){
                return id;
            }
        }
        return 0;
    }

}
