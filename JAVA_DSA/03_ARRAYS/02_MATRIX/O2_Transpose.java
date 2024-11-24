

import java.util.Arrays;

public class O2_Transpose {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Transpose the matrix in-place (only above the diagonal)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++) {  // Start j from i+1 to avoid swapping the diagonal
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        System.out.println("Transposed");

        // Print the transposed matrix
        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));
        }
    }
}

/*
Transposed
[1, 4, 7]
[2, 5, 8]
[3, 6, 9]
 */