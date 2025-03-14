import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindNames {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", null, "Charlie", null, "David");

        List<String> FindNames = names.stream().filter(name -> name != null).collect(Collectors.toList());

        FindNames.forEach(name -> System.out.print(name + " "));

       // another type to print
       // FindNames.forEach(System.out::println);
    }

}
