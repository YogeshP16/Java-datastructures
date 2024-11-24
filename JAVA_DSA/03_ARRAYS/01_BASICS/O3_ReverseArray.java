

public class O3_ReverseArray {
    public static void main(String[] args) {
       //  Initialize an array
        int[] arr = {1, 2, 3, 4};

        // Print the reversed array in the desired format
        System.out.print("reversed: ");
        for (int i = arr.length - 1; i >= 0; i--) { // Loop from the last element to the first

            if (i != 0) {
                System.out.print(arr[i] + ","); // Add a comma for all but the last element
            } else {
                System.out.print(arr[i]); // Avoid a trailing comma
            }
            
        }
    }

}


    