import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class O03_FindEven {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,3,34,57,4,77,88);

        List<Integer> findeven = list.stream().filter(n -> n% 2==0).collect(Collectors.toList());
        findeven.forEach(n -> System.out.print(n+ " "));  // 12 34 4 88 
        
        
    }
}
