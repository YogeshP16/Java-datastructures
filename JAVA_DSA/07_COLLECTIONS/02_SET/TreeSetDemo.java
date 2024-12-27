import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("zeke");
        set.add("amy");
        set.add("amy");
        set.add("loki");
        set.add("yogi");
        set.add("dini");

        System.out.println(set);  // [amy, dini, loki, yogi, zeke]  --> Maintains order


    }

}
