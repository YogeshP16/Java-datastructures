public class OO2_Linear_Search_2D {

    static int[] two_D_linear(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j}; // Return the indices as an array
                }
            }
        }
        return new int[]{-1, -1}; // Return {-1, -1} if the target is not found
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int target = 6;
        int[] res = two_D_linear(arr, target); // Store result in an int[] array
        System.out.println("Target found at: ["+ "row: " + res[0] + ", " + "col: "+ res[1] + "]");
    }
}

