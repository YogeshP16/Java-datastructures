/*

Fully sorted matrix:

Both rows and columns are sorted, 
and every element in the next row is greater than the last element of the previous row.

Example:

1  3  5
7  9  11
13 15 17

Approach 1: Binary Search on a Fully Sorted Matrix
For a matrix where all rows and columns are sorted , you can treat it as a 1D array and apply binary search.

Calculate the 1D index as if the matrix were flattened:

Index in 1D: i * cols + j
Use row = index / cols and col = index % cols to map back to the 2D matrix.


### **Explanation of Code**

1. **Flattening the Matrix**:
   - The matrix `[1, 3, 5], [7, 9, 11], [13, 15, 17]` is treated as if it's:  
     `[1, 3, 5, 7, 9, 11, 13, 15, 17]`.

2. **Midpoint Calculation**:
   - For ( text{mid} = 4 ) in the 1D space:  
     - Row = ( 4 div 3 = 1 ) (2nd row, 0-indexed).  
     - Column = ( 4 % 3 = 1 ) (2nd column, 0-indexed).

   - This corresponds to `matrix[1][1] = 9`.

3. **Search Logic**:
   - Compare `matrix[row][col]` with the target.
   - Adjust `start` and `end` indices just like binary search on a 1D array.

---

### **Complexity Analysis**

- **Time Complexity**:  
 ---->  ( O(log(m * n)) ), where ( m ) is the number of rows and ( n ) is the number of columns.  
  Same as standard binary search.

- **Space Complexity**:  
  ( O(1) ), as no extra space is used.

 */

public class OO4_BS_2D_Fully_Sorted {
    static boolean fullySorted_BS(int[][] arr, int target){
            int rows = arr.length;               // row length --> 3
            int cols = arr[0].length;            // col length --> 3
    
            // flatten 2D into 1D array
    
            int start = 0;                       // start index
            int end = rows * cols - 1;           // end index --> (3 * 3 -1) --> 9-1 --> total 8 index 
    
            while (start <= end){
                int mid = start + (end - start)/2;
    
                // convert one D {MID value}-->  back into 2D 
                int row = mid / cols;
                int col = mid % cols;
    
                if(target < arr[row][col]){
                    end = mid-1;                       // left half

                }else if (target > arr[row][col]){
                start = mid+1;                         // right half

                } else{
                    return true;                // if(target == arr[row][col])
                }
            }
            return false;

    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };  // --> 3 * 3 matrix

        int target = 7;
        boolean res = fullySorted_BS(arr, target);
        System.out.println(res);
    }


}
