

/*
 * Find the sum of all elements in an array
Key Concept: Accumulate all elements of the array.

Approach:

Initialize sum to 0.
Add each element of the array to sum.
Example:

Input: [1, 2, 3, 4] → Output: Sum: 10
 */

public class O1_SumofElements {
    public static void main(String[] args) {
        int[] arr = {12,23,4,56,67};

        //find sum

        int sum =0;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];  

        }
        System.out.println("sum : "+sum);

        // find average

        double avg = (double)sum/arr.length;
        System.out.println("avg : "+avg);



        
        
    }
    

}
