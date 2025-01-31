import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectDemo {

    public static void main(String[] args) {
        
        List<String> strings = Arrays.asList("apple", "Orange", "Oval", "adobe", "Grape", "oracle" );

        // Grouping by() -> {a=[apple, adobe], G=[Grape], o=[oracle], O=[Orange, Oval]}
        Map< Character, List<String>> group = strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(group);

        // Joining() -> apple, Orange, Oval, adobe, Grape, oracle
        List<String> strings2 = Arrays.asList("apple", "Orange", "Oval", "adobe", "Grape", "oracle" );
        String res = strings2.stream().collect(Collectors.joining(", "));
        System.out.println(res);

        // toList() - [1, 23, 23, 45, 45, 6, 7, 8, 9]
        List<Integer>  list = Arrays.asList(1,23,23,45,45,6,7,8,9);
        List<Integer> res1 = list.stream().collect(Collectors.toList());
        System.out.println(res1);

        // toMap() - {1=1, 6=1, 7=1, 23=2, 8=1, 9=1, 45=2}
        List<Integer>  list2 = Arrays.asList(1,23,23,45,45,6,7,8,9);
        Map<Integer, Integer> res2 =list2.stream().collect(Collectors.toMap( x -> x, x-> 1, Integer::sum));
        System.out.println(res2);

        //toSet() - List<Integer>  list = Arrays.asList(1,23,23,45,45,6,7,8,9);
        List<Integer>  list3 = Arrays.asList(1,23,23,45,45,6,7,8,9);
        Set<Integer> res3 = list3.stream().collect(Collectors.toSet());
        System.out.println(res3);

        // Partition by whether the number is even or odd
        List<Integer> list4  = Arrays.asList(1,23,23,45,45,6,7,8,9);
        Map<Boolean, List<Integer>> partitioned = list4.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);  // Output: {false=[23, 45, 7], true=[12, 56]}







    }
}
