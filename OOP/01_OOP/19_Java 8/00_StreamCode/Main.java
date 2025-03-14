import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello there !");


        /*prin list using stream
        List<String>  list = Arrays.asList("Hello", "there");
        list.stream().forEach(names -> System.out.println(names));

        // find even 
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> even = list2.stream().filter(n ->  n % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

        // filter out odd numbers
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> odd = list3.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
        System.out.println(odd);

        // find max
        List<Integer> list4 = Arrays.asList(1,2,3,4);
        Integer max = list4.stream().max(Integer::compare).get();
        System.out.println(max);

        // find 2nd  max
        List<Integer> list5 = Arrays.asList(1,2,3,4);
        Integer nthMax = list5.stream().sorted().skip(2).findFirst().get();
        System.out.println(nthMax); 

        // find Min
        List<Integer> list6 = Arrays.asList(1,2,3,4);
        Integer min = list6.stream().min(Integerr::compareTo).orElse(null);
        System.out.println(min);

        // find Duplicates
        List<Integer> list7 = Arrays.asList(1,1,2,2,3,4,5,5);
        List<Integer> duplicaates = list7.stream().filter(n -> Collections.frequency(list7, n) > 1).collect(Collectors.toSet());
        sysout.println(duplicates);

        // find length of each String
        List<String> names = Arrays.asList("hello", "there", "howitsgoing");
        Map<Integer, List<String>> findLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(findLength);

        // Count the Occurrence of list
        List<String> nameList = Arrays.asList("Hello", "hello", "Hi", "Hi", "Hi", "there");
        Map<Object, Long> findOccurrence =nameList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(findOccurrence);

        // count occurrence of String
        String str = "Hello Hello there Hi Hi Hi HI"
        Map<String, Long> findOccurrence = str.split("\\s+").stream().collect(Collectors.grouingBy(s -> s, Collectors.counting()));

        // joining he sentence
        List<String> words = Arrays.asList("Hello", "hello", "Hi", "Hi", "Hi", "there");
        String sentence = words.stream().collect(Collectors.joining(" "));
        System.out.println(sentence);

        // sort employee by salary
        List<Employee> sorted = employees.stream().sorted(Comparator<T>.comparingInt(e -> e.salary)).collect(Collectors.toList());
        System.out.println(sorted);

        // find firsy non repeating charaters
        String str = "aaabccd";
        Character result = str.stream().mapToObj(c -> (char) c).filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).findFirst().orElse(null);
        System.out.println(result); 

        //find character Occurrence
        String str2 = "aaaaaaabcsssssdddd";
        Map<Character, Long> charOccurrence = str2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(charOccurrence);

        // group employee by department
        Map<String, List<Employee>> groupByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(groupByDept); 

        // sum element in the list
        List<Integer> list = Arrays.asList(12,34,45);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // find unique element in the list
        List<Integer> list2 = Arrays.asList(1,1,1,2,3,3,4);
        List<Integer> unique = list2.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);

        // find names start with 'A'
        List<String> names = Arrays.asList("Anu", "Alpha", "Beta");
        List<String> startWithA  = names.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());
        System.out.println(startWithA);

        // ascending order
        List<String> asc = names.stream().sorted().collect(Collectors.toList());

        // Descending order
        List<String> desc = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        // flatten  the list
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6)
        );
        List<Integer> flat = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flat);

        // partionby -> split into two
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> partion = nums.stream().collect(Collectors.partitioningBy(n ->n % 2==0));
        System.out.println(partion); 

        // Find longest word in List
        List<String> words = Arrays.asList("Hello", "hello", "Hi", "Hi", "Hi", "there");
        String longestWord = words.stream().max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(longestWord); 

        // find common elements between two  list
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(2,3,5,6);
        List<Integer> findCommon = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(findCommon);

        List<String> words1 = Arrays.asList("Hello", "Hi", "there");
        List<String> words2 = Arrays.asList("Hello","Hi", "Hi");
        List<String> findCommonStrings = words1.stream().filter(words2::contains).collect(Collectors.toList());
        System.out.println(findCommonStrings);

        // find difference (unique) between two list
        // element present in one list but not in others
        List<Integer> list3 = Arrays.asList(1,2,3,4);
        List<Integer> list4 = Arrays.asList(2,3,5,6);
            // find diif in list 3
        List<Integer> findDiffL3 = list3.stream().filter(e -> !list4.contains(e)).collect(Collectors.toList());
            // find fiff in list4
        List<Integer> findDiffL4 = list4.stream().filter(e -> !list3.contains(e)).collect(Collectors.toList());
            // merge both
        List<Integer> unique = new ArrayList<>();
        unique.addAll(findDiffL3);
        unique.addAll(findDiffL4);
        System.out.println(unique);  

        // merge two list without duplicates
        List<Integer> list1 = Arrays.asList(1,2,2,3,4);
        List<Integer> list2 = Arrays.asList(8,2,3,5,6);
        List<Integer> merge = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        System.out.println(merge); 

        // merger two list sorted order
        List<Integer> list1 = Arrays.asList(1,2,2,3,4);
        List<Integer> list2 = Arrays.asList(8,2,3,5,6);
        List<Integer> mergerIntegerSortedOrder = Stream.concat(list1.stream(),list2.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println(mergerIntegerSortedOrder);   

        // Convert to Uppercase
        List<String> words1 = Arrays.asList("Hello", "Hi", "there");
        List<String> words2 = Arrays.asList("Hello","Hi", "Hi");
        List<String> toUppeStrings = Stream.concat(words1.stream(), words2.stream()).map(String::toUpperCase).distinct().collect(Collectors.toList());
        System.out.println(toUppeStrings
        ); 

        // Group words by length  from both list
        List<String> words1 = Arrays.asList("Hello", "Hi", "there");
        List<String> words2 = Arrays.asList("hello","Hi", "fi");
        Map<Integer, List<String>> grouingBy = Stream.concat(words1.stream(), words2.stream()).distinct().collect(Collectors.groupingBy(String::length));
        System.out.println(grouingBy);

        // find second max value or salary
        // skip -> 1 means  second max, 2 -> means third max
        List<Integer> list5 = Arrays.asList(1,2,3,4,89,67,100);
        Integer nthMax = list5.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(nthMax);  

        // find smallest value
        List<Integer> list = Arrays.asList(1,2,3,4,89,67,100);
        Integer nthMin = list.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
        System.out.println(nthMin);

        // top 3 highest paid employee
        List<Employee> top3Employees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList()); */
        














    


        











        
    }


    
}
