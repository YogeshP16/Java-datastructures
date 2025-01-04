import java.util.HashSet;

public class O11_FindUnion {
    public static void main(String[] args) { // return records from both arr
        int [] a= {1,2,3};
        int[] b = {4,5,6};
        HashSet<Integer> res  =  union(a,b);
        System.out.println(res);   // [1,2,3,4,5,6]
    }
    static HashSet<Integer> union(int[] a, int[] b){
        HashSet<Integer> set = new HashSet<>();       

        for(int num : a){
            set.add(num);
        }
        for(int num : b){
            set.add(num);
        }
        return set;
    }

}
