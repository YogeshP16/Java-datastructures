import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStrings {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("zen", "dine", "yoki", "anu");
        
        // Using an anonymous class for Comparator
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // Sort in ascending order
            }
        });

        System.out.println(names); // Output: [anu, dine, yoki, zen]
    }
}
