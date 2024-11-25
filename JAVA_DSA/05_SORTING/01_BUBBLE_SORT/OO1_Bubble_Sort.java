public class OO1_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {2, 34, 45, 7, 89, 3};
        bubblesort(arr); // Sort the array
        for (int num : arr) { // Print the sorted array
            System.out.print(num + " ");
        }
    }

    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // Swap arr[j] and arr[j-1]
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
