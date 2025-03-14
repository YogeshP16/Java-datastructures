
import java.util.*;
import java.util.stream.Collectors;

public class O08_CountWords {
    public static void main(String[] args) {
        String str = "apple banana apple orange banana apple";

        Map<String, Long> wordCount = Arrays.stream(str.split("\\s+")) // Split by spaces
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordCount);
    }
}
// {orange=1, banana=2, apple=3}