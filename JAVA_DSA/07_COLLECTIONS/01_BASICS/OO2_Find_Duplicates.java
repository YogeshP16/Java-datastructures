
import java.util.HashSet;
import java.util.Set;

public class OO2_Find_Duplicates {
    public static void main(String[] args) {
       int [] n1 = {1,22,3,44,5,6,6};
       
       int res = findDuplicates(n1);
       System.out.println(res);

    }
    static int findDuplicates(int[]n1){
        Set<Integer> seen = new HashSet<>();
        for(int num : n1){
            if(!seen.add(num)){
                return num;
            }
        }
        return 0;

    }

}
