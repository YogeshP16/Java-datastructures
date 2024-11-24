

import java.util.Arrays;

public class O9_MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] mergedArray = bruteForceMerge(arr1, arr2);

        // Print the merged array
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] bruteForceMerge(int[] arr1, int[] arr2) {
        // Step 1: Concatenate both arrays
        int[] mergedArray = new int[arr1.length + arr2.length];
        int index = 0;

        for (int num : arr1) {
            mergedArray[index++] = num;
        }
        for (int num : arr2) {
            mergedArray[index++] = num;
        }

        // Step 2: Sort the merged array
        Arrays.sort(mergedArray);

        // Step 3: Return the merged and sorted array
        return mergedArray;
    }

}
