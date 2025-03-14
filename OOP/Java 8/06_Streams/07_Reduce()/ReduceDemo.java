import java.util.Arrays;
import java.util.List;

public class ReduceDemo {
    // for custom logic we go for reduce()

    public static void main(String[] args) {

        // Sum of elements
        List<Integer> list = Arrays.asList(12, 23, 45, 56, 7);
        
        // `reduce()` starts with initial value `0` and adds each element to it
        int sum = list.stream().reduce(0, (a, b) -> (a + b));
        System.out.println(sum);  // Output: 143

        // Concatenate Strings
        List<String> list2 = Arrays.asList("Hi", "There");
        
        // `reduce()` starts with an empty string `""` and concatenates each string to it
        String concat = list2.stream().reduce("", (a, b) -> (a + b));
        System.out.println(concat);  // Output: HiThere
        
    }
}
