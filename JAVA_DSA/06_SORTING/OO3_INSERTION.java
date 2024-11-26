/*
 ### Insertion Sort Simplified  

**What is Insertion Sort?**  
A sorting algorithm that builds the sorted array one element at a time by inserting each unsorted element into its correct position.

---

**How It Works:**  
1. Start with the first element (assume it's sorted).  
2. Pick the next element.  
3. Compare it with elements in the sorted portion (left side).  
4. Shift larger elements to the right to make space.  
5. Insert the current element into its correct position.  
6. Repeat until the entire array is sorted.

---

**Complexity:**  
- **Time:**  
  - Worst/Average Case:  (O(n^2) ) (e.g., reversed order).  
  - Best Case:  (O(n) ) (e.g., nearly sorted).  
- **Space:**  (O(1) ) (in-place sorting).  

---

**When to Use:**  
- Small or nearly sorted datasets.  
- When simplicity is preferred over speed.  
- Low memory constraints.  
 */


public class OO3_INSERTION {
    public static void main(String[] args) {
        int [] arr = {11,45,67,3,8,90};
        insertion(arr);
        for (int i : arr) {
            System.out.print(i + " ");
            
        }
        
    }
    static void insertion(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            // take key as 1st index and j as previous index
            int key =arr[i], j = i-1;

            // check j>0 and j > key or not
            // if greater --> swap, move j 
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;


        }

    }
}
