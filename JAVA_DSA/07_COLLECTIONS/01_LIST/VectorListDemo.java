import java.util.Vector;

public class VectorListDemo {  // threadsafe list but slower
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();

        v.add(12);
        v.add(23);
        v.add(56);
        v.add(34);
        v.add(67);

        System.out.println(v);  // [12, 23, 56, 34, 67]


    }

}
