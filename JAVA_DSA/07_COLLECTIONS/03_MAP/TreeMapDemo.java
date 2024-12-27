import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> m = new TreeMap<>();

        // add
        m.put(3, "apple");
        m.put(2, "orange");
        m.put(4, "banana");
        m.put(5, "grape");
        m.put(6, "cherry");

        System.out.println(m);  // {2=orange, 3=apple, 4=banana, 5=grape, 6=cherry} --> maintains order

        // access
        System.out.println(m.get(2)); // orange

        //traverse
        for(Integer k : m.keySet()){
            String value = m.get(k);
            System.out.println( k + " : " + value);
        }

    }

}
