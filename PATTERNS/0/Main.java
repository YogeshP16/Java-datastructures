import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,2,3,3,4,5);
        List<Integer> list2 = Arrays.asList(1,2,3);

       // List<Integer> result = list1.stream().distinct().filter(list2::contains).collect(Collectors.toList());
       List<Integer> result = list1.stream().distinct().filter(e -> !list2.contains(e)).collect(Collectors.toList());
        System.out.println(result);


        

        
        

    }

}




