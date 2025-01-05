
/*
 Cyclic sort --> if question --> array of integer contains range  of  {1, N} or {0,N} 
                 ex : find missing numbers, 
                 find duplicates, 
                 find all duplicats, 
                 find all numbers disappeared in the array, 
                 set mismatch
                 first missing postive 

### Important
- if range --> [0, N]  --> every element will be at index = value      ---> arr[i]
- if range --> [1, N]  --> every element wil be at index = value - 1   ---> arr[i] - 1


Input: arr[] = [5,4,3,2,1] 
Output: [1,2,3,4,5]
Explanation: After removing the duplicates 2 and 3 we get 2 3 7 5.
 */

 import java.util.Arrays;

 public class OO1_Sort_Arrays{
     public static void main(String[] args) {
         int[] arr = {5,4,3,2,1};   // ------------> here range is {1 to N} --> arr[i]-1
         cyclic(arr);
         System.out.println(Arrays.toString(arr));
             
     }
     static void cyclic(int[] arr) {
         int n = arr.length;         // Get the length of the array
         int i = 0;                  // Start from the first element
     
         while (i < n) {
             // Calculate the correct index for the current element (value - 1)
             int correct_index = arr[i] - 1;
     
             // Check if the current element is not at its correct index
             if (arr[i] != arr[correct_index]) {
                 // If not, swap the current element with the element at its correct index
                 int temp = arr[i];
                 arr[i] = arr[correct_index];
                 arr[correct_index] = temp;
             } else {
                 // If it's at the correct index, move to the next element
                 i++;
             }
         }
     }
 }   
 