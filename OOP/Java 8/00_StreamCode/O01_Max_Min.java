import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class O01_Max_Min {
    public static void main(String[] args) {

        // find max
        Stream<Integer> stream = Stream.of(23,45,1,2,67,89,3,5,778);

        Optional<Integer> findmax = stream.max(Comparator.comparing(Integer :: valueOf));
        System.out.println("max -> " + findmax.orElse(-1));  // max -> 778

        
        // find min
        Stream<Integer> stream1 = Stream.of(23,45,1,2,67,89,3,5,778);

        Optional<Integer> findmin = stream1.min(Comparator.comparing(Integer :: valueOf));
        System.out.println("Min -> " + findmin.orElse(-1));  // Min -> 1
    }

}
