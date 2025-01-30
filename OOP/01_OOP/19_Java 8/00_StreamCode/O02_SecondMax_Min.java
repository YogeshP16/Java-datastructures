import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;


public class O02_SecondMax_Min {
    public static void main(String[] args) {

        // second max
        Stream<Integer> list = Stream.of(11,23,45,1,67,78,5,90);

        Optional<Integer> findSecondMax = list.sorted(Comparator.reverseOrder())
                                                .distinct()  // remove duplicates
                                                .skip(1)  //skip the first element
                                                .findFirst();  // get the second element

        System.out.println(findSecondMax);  // 78


        // second min
        Stream<Integer> list2 = Stream.of(11,23,45,1,67,78,5,90);

        Optional<Integer> findSecondMin = list2.sorted(Comparator.naturalOrder()).distinct().skip(1).findFirst();
        System.out.println(findSecondMin); // 5
    }

}
