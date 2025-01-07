
/*
Given an array of ints, return the number of 9's in the array.

arrayCount9([1, 2, 9]) → 1
arrayCount9([1, 9, 9]) → 2
arrayCount9([1, 9, 9, 3, 9]) → 3


Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.

arrayFront9([1, 2, 9, 3, 4]) → true
arrayFront9([1, 2, 3, 4, 9]) → false
arrayFront9([1, 2, 3, 4, 5]) → false


Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.

array123([1, 1, 2, 3, 1]) → true
array123([1, 1, 2, 4, 1]) → false
array123([1, 1, 2, 1, 2, 3]) → true
 */
public class O01_CountTarget {
    public static void main(String[] args) {
        int[] nums = {1,2,9,9,9};  
        System.out.println(arrayCount9(nums) + " times present");    // 3 times present    

        System.out.println(arrayFront9(nums)); // true;

        
    }
    public static int arrayCount9(int[] nums) {
        int count =0;
        for(int i=0; i< nums.length; i++){
          if(nums[i] == 9){
            count++;
          }
        }
        return count;
    }

    public static boolean arrayFront9(int[] nums) {
        int end = nums.length;
        if(end > 4) end = 4;
        
        for(int i=0; i< end; i++){
          if(nums[i] == 9){
            return true;
          }
        }
        return false;
        
    }
      



}
