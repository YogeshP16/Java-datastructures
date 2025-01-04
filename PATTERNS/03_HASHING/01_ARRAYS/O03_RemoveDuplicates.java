/*
1. Print all Distinct (Unique) Elements in given Array
Input: arr[] = [2, 2, 3, 3, 7, 5] 
Output: [2, 3, 7, 5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.

2. Print unique elements length in the array
input: arr[] = [2, 2, 3, 2]
Output: 2
Explanation: Distinct elements size are {2, 3}

3. Contains Duplicates or not
input: arr[] = [2, 2, 3, 2]
Output: true

 */

import java.util.ArrayList;
import java.util.HashSet;

public class O03_RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,5,5,5,5};

         // find unique elements length
         int result = distinctLength(arr);    //  5   -> total five unique elements
         System.out.println(result);

        // remove duplicates from the array
        ArrayList<Integer> res = removeDuplicates1(arr);  // [1, 2, 3, 4, 5]
        System.out.println(res);

        // contains duplicates in the array
        boolean res1 = containsDuplicates(arr);    // true
        System.out.println(res1);
    }

    // brute force  --> tc , sc --> o(n), o(1)
    static int distinctLength(int[] arr){
        ArrayList <Integer> list = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            int j;
            for(j=0; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    break;
                }
            }
            if(i==j){
                list.add(arr[i]);   // it will add to list --> [1, 2, 3, 4, 5]
            }
        }
        return list.size();   // it will find the length of unique elements ---> 5 (total 5 unique elements)

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
        return list;  // it will return list --> [1, 2, 3, 4, 5]
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
