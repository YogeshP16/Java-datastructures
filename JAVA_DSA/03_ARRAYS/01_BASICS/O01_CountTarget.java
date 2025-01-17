
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

Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7.

array667([6, 6, 2]) → 1
array667([6, 6, 2, 6]) → 1
array667([6, 7, 2, 6]) → 1
 */
public class O01_CountTarget {
    public static void main(String[] args) {
        int[] nums = {1,2,3,9,9,9,6,6,2,6,7,8};  
        System.out.println(arrayCount9(nums) + " times present");    // 3 times present    

        System.out.println(arrayFront9(nums)); // true

        System.out.println(array123(nums)); // true

        System.out.println(array667(nums));  // 2

        
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

    public static boolean array123(int[] nums) {
      for(int i=0; i< (nums.length-2); i++){
        if(nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3){
          return true;
        }
      }
      return false;
      
      
    }

    public static int array667(int[] nums) {
      int count =0;
      
      for(int i =0; i< (nums.length-1); i++){
        if(nums[i] == 6){
          if(nums[i+1] == 6 || nums[i+1] == 7){
            count++;
          }
        }
      }
      return count;
      
    }
    
      



}
