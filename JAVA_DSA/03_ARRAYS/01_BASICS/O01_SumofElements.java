public class O01_SumofElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // Calculate sum of elements
        int res = sum(arr);
        System.out.println(res);  // Output: 15

        // Calculate average of elements
        double res1 = average(arr, res);
        System.out.println(res1);  // Output: 3.0

        // Calculate cumulative sum of elements
        int[] res2 = cumulativeSum(arr);
        for (int i : res2)
            System.out.print(i + " ");  // Output: 1 3 6 10 15
    }

    // Function to calculate the sum of elements in an array
    static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Function to calculate the average of elements in an array
    static double average(int[] arr, int sum) {
        return (double) sum / arr.length;
    }

    // Function to calculate the cumulative sum of elements in an array
    static int[] cumulativeSum(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];  // Initialize the first element

        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }
        return result;
    }
}
