/*
 ### Insertion Sort Simplified  

**What is Insertion Sort?**  
---> always takes an element and place it in a correct position.

---

**How It Works:**  
Loop through each element starting from index 1.
Compare the current element with the previous one.
Shift elements greater than the current element one position to the right.
Insert the current element in its correct position

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
        int [] arr = {5,4,3,2,1};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
            
        }
        
    }
    static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i< n; i++){
            int j=i;
            while (j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
                
            }


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
