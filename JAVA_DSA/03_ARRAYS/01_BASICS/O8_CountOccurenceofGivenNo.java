
/*
 * Count occurrences of a given element in an array
Key Concept: Traverse the array and count matches with the given element.

Approach:

Initialize a counter to 0.
Increment the counter for every match found.
Example:

Input: [1, 2, 3, 2, 4], Element: 2 → Output: Occurrences: 2
 */

public class O8_CountOccurenceofGivenNo {
    public static void main(String[] args) {

        int [] arr = {12,34,4,5,6,6,6,6,6,66,6,78,9,6};
        int target = 6;
        int count =0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] == target){
                count++;
            }
        }
        System.out.println("6 occurs " + count + " times"); //6 occurs 7 times
        
    }

}
