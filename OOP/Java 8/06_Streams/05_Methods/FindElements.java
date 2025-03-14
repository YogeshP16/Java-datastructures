import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FindElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 43, 56, 78, 89, 90);

        // findFirst()
        Optional<Integer> element = list.stream().findFirst();
        System.out.println(element.orElse(-1));  // Prints first element or -1 if not found

        // findAny()
        Optional<Integer> element1 = list.stream().findAny();
        System.out.println(element1.orElse(-1));  // Prints any element or -1 if not found

        // count()
        Stream<Integer> stream1 = Stream.of(1, 1, 2, 34, 5, 6, 7, 8, 9, 9, 9);
        long count = stream1.count();  // Count -> 11
        System.out.println("Count -> " + count);

        // min()
        Stream<Integer> stream2 = Stream.of(1, 1, 2, 34, 5, 6, 7, 8, 9, 9, 9);  
        Optional<Integer> minElement = stream2.min(Comparator.comparing(Integer::valueOf));
        System.out.println("Min -> " + minElement.orElse(-1));  // Min -> 1

        // max()
        Stream<Integer> stream3 = Stream.of(1,1,2,3,4,5,6,6,78,89,90);
        Optional<Integer> maxElement = stream3.max(Comparator.comparing(Integer::valueOf));
        System.out.println("Max -> " + maxElement.orElse(-1));  // Max -> 90

        
    }
}

