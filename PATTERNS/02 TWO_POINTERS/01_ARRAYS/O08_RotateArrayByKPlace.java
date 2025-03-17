public class O08_RotateArrayByKPlace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3; // Number of places to rotate
        rotateLeft(arr, k);
        for (int i : arr) {
            System.out.print(i + " "); // Expected output: 4 5 6 7 1 2 3
        }
    }

    static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        if (k == 0) return;

        reverse(arr, 0, k - 1);   // Reverse the first k elements
        reverse(arr, k, n - 1);   // Reverse the remaining n-k elements
        reverse(arr, 0, n - 1);   // Reverse the entire array
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
