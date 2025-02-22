import java.util.Arrays;

public class O1_Traverse {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {23, 45, 67}, {56, 78, 9}};

        // Traverse using traditional for loop
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Traverse using enhanced for loop
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Print each row using Arrays.toString
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/*
Output:

1 2 3 
23 45 67 
56 78 9 

1 2 3 
23 45 67 
56 78 9 

[1, 2, 3]
[23, 45, 67]
[56, 78, 9]
*/
