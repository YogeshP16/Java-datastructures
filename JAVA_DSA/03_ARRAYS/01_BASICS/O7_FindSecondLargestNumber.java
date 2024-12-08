

/*
 * Find the second largest number in an array
Key Concept: Identify the largest, then find the next largest distinct number.

Approach:

Initialize first and second as Integer.MIN_VALUE.
Traverse the array to update first and second accordingly.

Example:

Input: [3, 5, 7, 2, 8] → Output: Second Largest: 7
 */

public class O7_FindSecondLargestNumber {
    public static void main(String[] args) {

        int[] arr = {12,34,56,78,89,89,89};
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        // to find max

        for(int i =0; i< arr.length; i++){
            if( arr[i] > largest){
                secondlargest = largest;
                largest = arr[i];

            // skip largest duplicates  

            }else if( arr[i] > secondlargest && arr[i] != largest  ){
                secondlargest=arr[i];
            }
        }
        System.out.println("Second largest; "+secondlargest);

        // to find Second smallest

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // To find the smallest and second smallest
        for (int i : arr) {
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;

                // used to skip duplicates of the smallest number 
            } else if (i < secondSmallest && i != smallest) {
                secondSmallest = i;
            }
        }

        System.out.println("Second smallest: " + secondSmallest);
    }

}
