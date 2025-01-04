import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class O08_Intersection {   // return matched elements from the both array
    public static void main(String[] args) {
        int [] a = {1,1,2,2,3,4,5,5,6};
        int[] b = {1,12,2,2,3};
        List<Integer> res  = intersectionn(a,b);
        for(int i: res){
            System.out.print(i + " ");  // 1,2,3
        }
    }

    // find common elements between two arrays
    static List<Integer> intersection(int[] a, int[] b){
        HashSet <Integer> set = new HashSet<>();
        for(int i : a){
            set.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : b){
            if(set.contains(num)){
                result.add(num);
                set.remove(num);
            }
        }
        return result;
    } 

    static List<Integer> intersectionn(int[] a, int[] b){
        List<Integer> result = new ArrayList<>(); 
        for(int i=0; i<a.length; i++){
            for(int j=0; j< b.length; j++){
                if(a[i] == b[j]){
                    if(!result.contains(a[i])){
                        result.add(a[i]);
                    }
                }
            }
        }
        return result;
    }

}
