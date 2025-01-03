
/*
 * Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
 
 
countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3


Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0. Return the changed array.
 
 
fix23([1, 2, 3]) → [1, 2, 0]
fix23([2, 3, 5]) → [2, 0, 5]
fix23([1, 2, 1]) → [1, 2, 1]
 */

import java.util.Map;

public class Main {
    public static void main(String[] args) {
     
     //   String s = "abcxx";
        int [] arr = {1,2,3};
        fix23(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }                                                           
        
    }
    static int[] fix23(int[] arr){
        for(int i=0; i< arr.length-1; i++){
            if(arr[i] == 2 && arr[i+1] == 3){
                arr[i+1] = 0;
            }
            
        }
        return arr;
    }
    
    /* 
    static HashMap<String, Integer> countOcc(String s){
        Map<String, Integer> map = new HahsMap<>();

        for(int )
    } */
}
