import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {  // threadsafe list
    public static void main(String[] args) {
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterate safely
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // Modify the list while iterating
        for (String fruit : list) {
            if (fruit.equals("Banana")) {
                list.add("Date");
            }
            System.out.println(fruit);
        }

        // Final state of the list
        System.out.println("Final List: " + list);
    }
}
/*
Apple
Banana
Cherry
Apple
Banana
Cherry
Final List: [Apple, Banana, Cherry, Date]
 */