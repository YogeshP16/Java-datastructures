import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class FindEvenNumbersInList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,23,45,54,5,6,7,8,9,10);

        List<Integer> even = list.stream().filter(n -> n % 2 ==0).collect(Collectors.toList());
        
        even.forEach(n -> System.out.print(n + " "));  // 2 54 6 8 10

    }

}
