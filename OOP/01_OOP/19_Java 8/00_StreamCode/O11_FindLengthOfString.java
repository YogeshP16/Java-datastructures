import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class O11_FindLengthOfString {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

    //  find length of string
    //=============================
    //  str.stream().map(s -> s + " = " + s.length()).forEach(System.out::println);


    // group string by length
    //=======================
    // Map<Integer, List<String>> groupbyLength = str.stream()
    // .collect(Collectors.groupingBy(String::length));

    // groupbyLength.forEach((length, stringList) -> System.out.println(length + " = " + stringList));




    }

}



/*
5 = [apple]
6 = [banana, cherry, grape]
4 = [date]
3 = [fig]

 */