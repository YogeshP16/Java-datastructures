/*
 * find first unique element -->  23,23,23,5,23,6,6,6,6
 * output ---> 5  --> value dont have any occurrence
 */



 import java.util.HashMap;
 public class O02_FirstNonRepeatingElements {
     public static void main(String[] args) {
         int[] arr = {4, -8, 1, -4, -3, -8, -3, -10, 3, -3, 10};
 
         System.out.println(firstNonRepeating(arr));        // 4
     }
     
     public static int firstNonRepeating(int[] arr) {
         HashMap<Integer, Integer> map = new HashMap<>();
         
         for(int i: arr){
             map.put(i, map.getOrDefault(i, 0)+1);
         }
         
         for(int i : arr){
             if(map.get(i) ==1){
                 return i;
             }
         }
         return 0;
         
         // Complete the function
     }

     
 
 }