/*
Given two arrays arr1[] and arr2[] of size m and n respectively, the task is to determine whether arr2[] is a subset of arr1[]. Both arrays are not sorted, and elements are distinct.

Examples: 
Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1} 
Output: Yes

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4} 
Output: Yes

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3} 
Output: No
 */

import java.util.HashSet;

public class O09_Subset {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6}; 
        int arr2[] = {1, 2, 4};
        System.out.println(checkSubset(arr1, arr2));  // true
        
    }

    static boolean checkSubsett(int[] arr1, int[] arr2){

        for(int i=0; i<arr1.length; i++){
            boolean found =false;

            for(int j=0; j< arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    found = true;
                    break;
                }
                if(!found) return false;
            }
        }
        return true;

    }
    // optimized  ---> tc o(n) sc o(n)
    static boolean checkSubset(int[] arr1, int[] arr2){
        HashSet <Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int j : arr2){
            if(!set.contains(j)){
                return false;
            }
        }
        return true;
    }


}
