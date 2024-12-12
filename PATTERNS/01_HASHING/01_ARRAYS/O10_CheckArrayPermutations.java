/*
###   Permutations    
A   permutation   is an arrangement of elements in a specific order.  

-   Order Matters  : Changing the order creates a different permutation.  
-   Example  : For  ([1, 2, 3] ), permutations are:  
   ([1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1] ).  -----> total 6 permutations

###   Permutations of Two Arrays    
Two arrays are permutations of each other if:
1. They contain the same elements.  
2. Elements have the same frequency.  

  Example  :  
-   Array A  :  ([1, 2, 3] ),   Array B  :  ([3, 1, 2] ) →   Yes   (Same elements).  
-   Array A  :  ([1, 2, 3] ),   Array B  :  ([3, 1, 1] ) →   No   (Different frequency).  
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class O10_CheckArrayPermutations {
    public static void main(String[] args) {
      int[] a = {1,2,3};
      int[] b = {1,2,3};
      boolean res = permutation(a, b);
      System.out.println(res);

        
    }
    static boolean permutationn(int[] a, int[] b){
      if( a.length != b.length) return false;

      Arrays.sort(a);
      Arrays.sort(b);

      return Arrays.equals(a,b);
    }

    static boolean permutation(int[] a, int[] b){
      if( a.length != b.length) return false;

      Map<Integer, Integer> map = new HashMap<>();

      // count the frequency of a
      for(int i: a){
        map.put(i, map.getOrDefault(i,0)+1);
      }

      // reduce the frequency of b
      for(int j: b){
        if(!map.containsKey(j) || map.get(j) ==0){
          return false;

        }
        map.put(j, map.get(j)-1);

      }
      // Check if all count =0
      for(int i: map.values()){
        if(i != 0) return false;
      }
      return true;
    }

}
