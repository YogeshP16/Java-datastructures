public class O07_LeftRotateArraybyOnePlace {

    // Function to rotate array to the left by one place
    public static void leftRotateByOne(int[] arr) {
        if (arr.length == 0) return;
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    // Function to rotate array to the right by one place
    public static void rightRotateByOne(int[] arr) {
        if (arr.length == 0) return;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original Array:");
        printArray(arr);

        leftRotateByOne(arr);
        System.out.println("Array after left rotation by one place:");
        printArray(arr);

        rightRotateByOne(arr);
        System.out.println("Array after right rotation by one place:");
        printArray(arr);
    }
}

/*
 * Original Array:
1 2 3 4 5 
Array after left rotation by one place:
2 3 4 5 1
Array after right rotation by one place:
1 2 3 4 5
 */