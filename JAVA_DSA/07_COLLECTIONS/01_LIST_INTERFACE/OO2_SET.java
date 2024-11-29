import java.util.HashSet;

public class OO2_SET {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // add
        set.add(12);
        set.add(34);
        set.add(35);
        set.add(34);
        set.add(36); 
        set.add(37);
        set.add(39);
        set.add(44); 

        System.out.println(set);

        // remove element directly
        set.remove(44);
        System.out.println(set);


    }

}
