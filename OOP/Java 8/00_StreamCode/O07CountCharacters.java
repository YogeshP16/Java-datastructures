import java.util.*;
import java.util.stream.Collectors;

public class O07CountCharacters {
    public static void main(String[] args) {
        String str = "hello world";

        Map<Character, Long> charCount = str.chars()  // Convert to IntStream
                .mapToObj(c -> (char) c)  
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(charCount);
    }
}


// { =1, r=1, d=1, e=1, w=1, h=1, l=3, o=2}