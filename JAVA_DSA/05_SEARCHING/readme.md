
  
 
## Algorithms
 
  ### Linear Search
  Linear search is a simple search algorithm that checks each element in the array
  sequentially until the desired element is found or the end of the array is reached.
 
  ### Binary Search
  Binary search is a more efficient search algorithm that works on sorted arrays.
  It repeatedly divides the search interval in half, comparing the target value to
  the middle element of the interval, and then narrowing the interval based on the comparison.
 
  ## Code Template
 
  ### Linear Search
  ```java
  public class LinearSearch {
      public static int linearSearch(int[] arr, int target) {
          for (int i = 0; i < arr.length; i++) {
              if (arr[i] == target) {
                  return i;
              }
          }
          return -1;
      }
  }
  ```
 
  ### Binary Search
  ```java
  public class BinarySearch {
      public static int binarySearch(int[] arr, int target) {
          int start = 0;
          int end = arr.length - 1;
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
  }
  ```
 
  ## When to Use
 
  - Use linear search when the array is unsorted or small, as it does not require
    the array to be sorted and has a simple implementation.
  - Use binary search when the array is sorted and you need a more efficient search
    algorithm, as it significantly reduces the number of comparisons needed.
 
  ## Time and Space Complexity
 
  ### Linear Search
  - Time Complexity: O(n), where n is the number of elements in the array.
  - Space Complexity: O(1), as it requires a constant amount of additional space.
 
  ### Binary Search
  - Time Complexity: O(log n), where n is the number of elements in the array.
  - Space Complexity: O(1), as it requires a constant amount of additional space.
 