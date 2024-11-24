

public class O2_FindMaximum {

    public static void main(String[] args) {

        // Array to find the maximum value
        int[] arr = {12, 34, 45, 6, 78, 90};   // Expected max output: 90

        // Initialize `max` with the first element of the array
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // Update `max` if the current element is greater than `max`
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // Print the maximum value
        System.out.println("Maximum value: " + max);

        // Array to find the minimum value
        int[] arr1 = {12, 34, 56, 7}; // Expected min output: 7

        // Initialize `min` with the first element of the array
        int min = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            // Update `min` if the current element is smaller than `min`
            if (arr1[i] < min) {
                min = arr1[i];
            }
        }
        // Print the minimum value
        System.out.println("Minimum value: " + min);
    }
}
