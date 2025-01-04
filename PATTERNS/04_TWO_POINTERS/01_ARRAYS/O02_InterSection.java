import java.util.Arrays;

/*
Pattern: Two Pointers
Use Case: Finding intersection of two sorted arrays
Key Steps:
1. Compare elements from both arrays:
   - If equal, add to the result and move both pointers.
   - If a[i] < b[j], move i forward.
   - If a[i] > b[j], move j forward.
2. Stop when one array is fully traversed.
3. Skip duplicates (if necessary).

Time Complexity: O(n + m)
Space Complexity: O(k) where k is the size of the result (intersection).

 */

public class O02_InterSection {
        public static void main(String[] args) {
            int[] a = {1,2,3,4};
            int[] b = {2,5,6,8};
            int[] res = intersection(a, b);
            System.out.println(Arrays.toString(res));

        }

        static int[] intersection(int[] a, int[] b){
            int n = a.length;
            int m = b.length;

            int[] result = new int[Math.min(n,m)];

            int i=0; int j=0; int k =0;

            while (i<n && j<m){
                if(a[i] == b[j]){
                    result[k++] = a[i];
                    i++;
                    j++;
                } else if(a[i] < b[i]){
                    i++;
                } else{
                    j++;
                }
            }
            return Arrays.copyOf(result, k);
        }

}
