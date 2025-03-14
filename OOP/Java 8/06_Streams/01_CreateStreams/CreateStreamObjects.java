import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CreateStreamObjects {
    public static void main(String[] args) {

        //create a stream
        Stream<String> stream = Stream.of("a", "b", "d", "c");
        stream.forEach(System.out :: println);  // here using method ref


        // Create stream from sources
        Collection<String> collection = Arrays.asList("zen", "zeke","jin", "jack");
        Stream<String> stream2 = collection.stream();
        stream2.forEach(System.out :: println);

        //create stream using list
        List<String> list = Arrays.asList("zen", "zeke","zen","jin", "jack");
        Stream<String> stream3 = list.stream();
        stream3.forEach(System.out :: println);

        // create stream using set
        Set<String> set = new HashSet<>(list);
        Stream<String> stream4 = set.stream();
        stream4.forEach(System.out::println);

        //create stream using arrays
        String[] arr = {"abs", "shoulder", "biceps"};
        Stream<String> stream5 = Arrays.stream(arr);
        stream5.forEach(System.out::println);

        
    }


}
