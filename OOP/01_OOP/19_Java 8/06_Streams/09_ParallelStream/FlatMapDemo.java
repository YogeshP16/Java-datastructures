import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("Java", "Spring"),
            Arrays.asList("Python", "Django"),
            Arrays.asList("JavaScript", "React")
        );

        List<String> flattenedList = nestedList.stream()
            .flatMap(List::stream)  // Flatten the lists
            .collect(Collectors.toList());

        System.out.println(flattenedList);
    }
}
