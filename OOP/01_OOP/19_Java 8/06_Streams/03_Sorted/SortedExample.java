import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Orange", "Grape", "Apple");

        // Sorting in ascending order (3 ways)
        List<String> sortFruits = fruits.stream().sorted().collect(Collectors.toList());
        System.out.println(sortFruits);  // [Apple, Banana, Grape, Orange]

        List<String> sortFruits2 = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sortFruits2);  // [Apple, Banana, Grape, Orange]

        List<String> sortFruits3 = fruits.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(sortFruits3);  // [Apple, Banana, Grape, Orange]



        //sorting in descending order
        List<String> sortFruits4 = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortFruits4);  // [Orange, Grape, Banana, Apple]

        List<String> sortFruits5 = fruits.stream().sorted((o1,o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(sortFruits5);  // [Orange, Grape, Banana, Apple]

        
        


    }

}
