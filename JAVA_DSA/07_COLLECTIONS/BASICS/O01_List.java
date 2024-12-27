import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class O01_List {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,1,12,2,2,3,3,3,5,5,6,67,7,8);
        int max = Collections.max(l);
        int min = Collections.min(l);
        System.out.println("max: "+ max + " & "+"min: " + min);  // 67, 1


        // reverse list

        Collections.reverse(l);
        System.out.println(l);


        // remove even numbers 

        List<Integer> lis = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        lis.removeIf(num -> num % 2 == 0);
        System.out.println(lis); // Output: [1, 3, 5]


        // find target

        int target  = 2;
        for(int i=0; i< lis.size(); i++){
            if(lis.get(i) == target){
                System.out.println(i);
            }
        }

        // merge two list
        List<Integer> l2 = Arrays.asList(56,67,78,89);
        List<Integer> l1 = Arrays.asList(34,56,77,8);
        List <Integer> merge = new ArrayList<>(l1);
        merge.addAll(l2);
        System.out.println(merge);  // [34, 56, 77, 8, 56, 67, 78, 89]

    }

}
