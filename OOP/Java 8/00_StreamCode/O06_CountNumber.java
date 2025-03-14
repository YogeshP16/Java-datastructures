import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class O06_CountNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23,23,23,45,67,67,89);

        Long count = list.stream().filter(n -> n ==23).count();
        System.out.println("23 appears " + count + " times");  // 23 appears 3 times


        List<Integer> list2 = Arrays.asList(23,23,23,45,67,67,89);

        Map<Integer, Long> count2 = list2.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(count2);  // {67=2, 23=3, 89=1, 45=1}
    }

}
