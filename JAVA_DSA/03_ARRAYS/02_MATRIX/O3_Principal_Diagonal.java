

/*Algorithm to Find the Sum of the Principal Diagonal in a Matrix:

Loop through the matrix.
For each row i, add the element at matrix[i][i] to the sum */


public class O3_Principal_Diagonal {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Principal Diagonal Elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }

        System.out.println();

        System.out.print("Sum of Principal Diagonal ");
        int sum=0;
        for(int i=0;i<arr.length; i++){             //Sum of Principal Diagonal 15
            sum += arr[i][i];
        }
        System.out.println(sum);
    }
}

// Principal Diagonal Elements: 1 5 9 