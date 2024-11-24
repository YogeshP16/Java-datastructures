

/*
Subarray

Definition: A contiguous portion of an array.

Key Point: Must maintain the order of elements and cannot skip elements.

Example: For array [1, 2, 3], subarrays are:
[1], [2], [3], [1, 2], [2, 3], [1, 2, 3].


Manipulations and Operations
Finding all subarrays:

______________________________________________________________________________________________________

Substring

Definition: A contiguous portion of a string.
Key Point: Similar to a subarray but applies to strings.

Example: For "abc", substrings are: 
"a", "b", "c", "ab", "bc", "abc".

Manipulations and Operations
Extract substring:

_______________________________________________________________________________________________________________

Subsequence

Definition: A sequence derived by deleting some or no elements without changing the order.
Key Point: Does not need to be contiguous.

Example: For "abc", subsequences are:
"", "a", "b", "c", "ab", "ac", "bc", "abc".

Manipulations and Operations
Generate all subsequences (recursive):

_____________________________________________________________________________________________________________________

SubSet

Definition: A set containing any combination of elements (order doesn’t matter).
Key Point: Similar to a subsequence but used in the context of sets (unique elements).

Example: For {1, 2, 3}, subsets are:
{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}.

Manipulations and Operations
Generate all subsets (Bitmasking):

 */

 
public class OO3_SUBARRAY_SUBSTRING {
    public static void main(String[] args) {

        // Sub Array

        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {        // i --> start index
            for (int j = i; j < arr.length; j++) {    // j --> end index
                for (int k = i; k <= j; k++) {        // k --> iterate i to j
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }

        System.out.println();


        // SubString

        String s = "abc";

        for(int i = 0; i < s.length(); i++){
            for(int j= i+1; j <= s.length(); j++)
            System.out.println(s.substring(i, j));
        }



        // Sub Set

        int[] arr1 = {1, 2, 3};
        int n = arr1.length;
        for (int i = 0; i < (1 << n); i++) { // 2^n subsets
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr1[j] + " ");
                }
            }
            System.out.println();
        }

        
    }

}
