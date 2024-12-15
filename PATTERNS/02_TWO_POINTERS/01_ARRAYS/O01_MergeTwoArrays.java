import java.util.Arrays;


/*
Pattern: Two Pointers
Use Case: Merging two sorted arrays
Key Steps:
1. Compare elements from both arrays.
2. Add the smaller one to the result.
3. Move the pointer of the chosen array forward.
4. Add remaining elements after one array is done.

Time Complexity: O(n + m)
Space Complexity: O(n + m)

 */

public class O01_MergeTwoArrays {
    public static void main(String[] args) {
        int [] a = {1,3,4};
        int [] b = {2,5,6,7,8};
        int[] res = mergeTwoArr(a, b);
        System.out.println(Arrays.toString(res));
    }
    static int[] mergeTwoArr(int[] a, int[] b){
        int n= a.length; int m = b.length;
        int [] result = new int[n+m];

        int i=0;  // i tracks the current position in a.

        int j=0;  // j tracks the current position in b.

        int k=0;  // k tracks the current position in result.

        // merge two arrays 
        while(i<n && j<m){
            if(a[i] <= b[j]){
                result[k++] = a[i++];
            } else{
                result[k++] = b[j++];
            }
        }

        // add remaining elements from a and b
        while(i<n){
            result[k++] = a[i++];
        }

        while(j<m){
            result[k++] = b[j++];
        }

        return result;
    }   

}
