/* 

How It Works (Merge Sort): --> Divide and conquer
-----------------------------
Divide the array into two halves.
Recursively sort each half.
Merge the two sorted halves into a single sorted array.
Repeat the process until the entire array is sorted.


Complexity:
------------
Time:
Worst/Average Case: O(n log n) (due to the divide and merge steps).
Best Case: O(n log n) (the process still requires dividing and merging even in the best case).

space --> O(n)

*/

import java.util.Arrays;

public class OO5_MERGE {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    static int[] mergeSort(int[] arr){

        // base case --> if array has only one element----> return  
        if(arr.length == 1) return arr;

        // divide into two half
        int mid = arr.length/2;

        // create a copy of an array 
        // orginal array will  not be modified
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // merge this two arrays
        return merge(left, right);

    }
    private static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i=0;
        int j=0;
        int k=0;  // pointer for new array

        while (i< first.length && j< second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            } else{
                mix[k] = second[j];
                j++;
            }
            k++;

        }

        // it may be possible one of the divided array is not sorted
        // only one of these two will be run
        // example first array--> [2,4,5] second array--> [5,6,7,8,9]
        // this while condition will check the remaining element in second array  --> [8,9]

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;

        }
        while(j < second.length){   // for [8,9]this condition will run
            mix[k] = second[j];
            j++;
            k++;

        }
        return mix;




    }

}
