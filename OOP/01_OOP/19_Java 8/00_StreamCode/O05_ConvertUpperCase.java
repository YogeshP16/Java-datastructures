import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class O05_ConvertUpperCase {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "there");

        List<String> toUpperCase = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        for (String res : toUpperCase) {
            System.out.print(res + " ");  //HELLO THERE 
            
        }
    }

}
