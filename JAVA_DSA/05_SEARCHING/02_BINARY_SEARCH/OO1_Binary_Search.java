// Binary Search ->  O(log n) --> efficient than linear search O(n)
// Binary Search works only on sorted array
// Binary Search is a divide and conquer algorithm

public class OO1_Binary_Search {  
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            // find mid
            int mid = start + (end - start) / 2;

            // focus --> left search space 
            if( target < arr[mid]){
                end = mid-1;

            // right search space
            }else if (target > arr[mid]){
                start = mid +1;

            // target equals to mid --> return it
            } else {
                return mid;
            }

        }
        return -1;

        }



        static int binarySearchTarget(int[] arr, int target){
        int index = binarySearch(arr, target);
        if (index != -1) {
            return arr[index];
        }
        return -1; // or any other value indicating not found
        }



        // Recursive Binary Search
        static int binarySearchRecursive(int[] arr, int target, int start, int end) {
            if (start > end) {
                return -1;
            }

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                return binarySearchRecursive(arr, target, start, mid - 1);
            } else if (target > arr[mid]) {
                return binarySearchRecursive(arr, target, mid + 1, end);
            } else {
                return mid;
            }
        }

        public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,67,78,90,123};   // sorted array
        int target = 78;
        int res = binarySearchTarget(arr, target);
        System.out.println("target found: "+ res);

        
        res = binarySearch(arr, target);
        System.out.println("target found at index: "+ res);
        }
    }


