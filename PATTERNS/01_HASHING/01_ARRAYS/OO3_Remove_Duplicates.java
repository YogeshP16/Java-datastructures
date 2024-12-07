/*
Print all Distinct (Unique) Elements in given Array

Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
 */

import java.util.ArrayList;
import java.util.HashSet;




public class OO3_Remove_Duplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,5,5,5,5};

        // remove duplicates from the array
        ArrayList<Integer> result = removeDuplicates(arr);    // [1, 2, 3, 4, 5]
        ArrayList<Integer> result1 = removeDuplicates1(arr);  // [1, 2, 3, 4, 5]

        // contains duplicates in the array
        boolean res = containsDuplicates(arr);    // true
        
        // Print the result after the method call
        System.out.println(result1);
     
    }

    // brute force  --> tc , sc --> o(n), o(1)
    static ArrayList<Integer> removeDuplicates(int[] arr){
        ArrayList <Integer> list = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            int j;
            for(j=0; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    break;
                }
            }
            if(i==j){
                list.add(arr[i]);
            }
        }
        return list;

    }

    // optimized --> tc - O(n), sc --> o(n)
    static ArrayList<Integer> removeDuplicates1(int[] arr){
        HashSet<Integer> set  = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            // if value not in the set just add it to set, list
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                list.add(arr[i]);
            }
        }
        return list;

    }

    // contains duplicate
    static boolean containsDuplicates(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int nums : arr){
            if(set.contains(nums)) return true;
            set.add(nums);
        }
        return false;
    }
    

}
