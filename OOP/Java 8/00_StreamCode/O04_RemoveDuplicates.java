import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class O04_RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4);

        List<Integer> removeIntegers = numbers.stream().distinct().collect(Collectors.toList());

        for (Integer res : removeIntegers) {
            System.out.print(res + " "); // 1 2 3 4 
            
        }

    }

}
