import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class O09_Sum_Avg {
    public static void main(String[] args) {

        // sum
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum); // 15

        // avg
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        OptionalDouble avg = numbers2.stream().mapToInt(Integer:: intValue).average();
        System.out.println(avg);  // OptionalDouble[3.0]


        
    }

}
