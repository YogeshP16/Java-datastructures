public class OO1_FOR {
    public static void main(String[] args) {

        int n = 5;

        // Print numbers from 0 to 4
        System.out.println("print 0 to 4");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");   // 0 1 2 3 4
        }
        System.out.println();

        // Print numbers from 0 to 5
        System.out.println("print 0 to 5");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");   // 0 1 2 3 4 5
        }
        System.out.println();

        // Print numbers from 1 to 5
        System.out.println("print 1 to 5");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");  // 1 2 3 4 5
        }
        System.out.println();

        // Print odd numbers from 1 to 9
        System.out.println("print odd");
        for (int j = 1; j <= 10; j += 2) {
            System.out.print(j + " ");  // 1 3 5 7 9
        }
        System.out.println();

        // Print even numbers from 1 to 10
        System.out.println("print even");
        for (int k = 1; k <= 10; k++) {
            if (k % 2 == 0) {
                System.out.print(k + " ");  // 2 4 6 8 10
            }
        }
        System.out.println();

        // Print numbers from 10 to 1 in reverse order
        System.out.println("print reverse");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");  // 10 9 8 7 6 5 4 3 2 1
        }
        System.out.println();

        // Enhanced for loop to print elements of an array
        System.out.println("For each loop");
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.print(num + " ");  // 1 2 3 4 5
        }
        System.out.println();

        // Create an array and print its elements from 0 to num-1
        int num = 4;
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);  // 0 1 2 3
        }
    }
}
