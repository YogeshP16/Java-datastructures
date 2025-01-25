import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortStrings {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("zen", "dine", "yoki", "anu");

        List<Integer> values = Arrays.asList(23,4,56,78,45,234,5466,5,3,1,7,11);
        
        // Using a lambda expression for Comparator

        Collections.sort(names, (o1, o2) -> o1.compareTo(o2)); // Ascending order
        System.out.println(names); // Output: [anu, dine, yoki, zen]

        Collections.sort(names,(o1,o2) -> o2.compareTo(o1)); // Reverse order
        System.out.println(names);  // [zen, yoki, dine, anu]
        
        Collections.sort(values, (o1,o2) -> o1.compareTo(o2));  // [1, 3, 4, 5, 7, 11, 23, 45, 56, 78, 234, 5466]
        System.out.println(values);


    }
}
