
/*Algorithm to Find the Sum of the Secondary Diagonal in a Matrix:

Loop through the matrix.
For each row i, add the element at matrix[i][n-1-i] to the sum (where n is the size of the matrix). */

//import java.util.Arrays;

public class O4_Secondary_Diagonal {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Secondary Diagonal: ");

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] [arr.length-1-i] + " ");   //Secondary Diagonal: 3 5 7
        }

        System.out.println();

        System.out.println("Sum of secondary diagonal ");   // 15

        int sum = 0;
        for(int i=0; i< arr.length; i++){
            sum+=arr[i][arr.length-1-i];
        }
        System.out.println(sum);
    }

}
