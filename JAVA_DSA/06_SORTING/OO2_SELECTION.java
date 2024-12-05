/*
### Selection Sort Simplified  

**What is Selection Sort?**  
- take the smallest element (min in the array) and swap it with first element 
- OR
- take the largest  element (max in the array) and swap it with last element


---

**Complexity:**  

- **Time:**  
  - Worst/Average Case:  (O(n^2) )  
  - Best Case (Nearly Sorted):  (O(n^2) )  
  - Comparisons:  (n  times (n - 1) / 2 )  

- **Space:**  (O(1) ) (in-place sorting, no extra memory needed)

---

**When to Use:**  
- Small datasets or nearly sorted arrays.  
- Limited memory.  
- Cases where minimizing swaps is critical.  


### Algo

Iterate through the array.
Find the smallest element in the unsorted part of the array.
Swap it with the first element of the unsorted part.
Repeat until the entire array is sorted.


 */



public class OO2_SELECTION {
    public static void main(String[] args) {
        int [] arr= {12,3,45,2,56,78,7};
        selection(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
        
    }
    static void selection(int[] arr){

        int n = arr.length;
        for(int i=0;  i< n-1; i++){            // iterate 

            int min = i;                       // asumme first element as min
            for(int j= i+1; j< n; j++){        // find smallest element in the array

                if(arr[j] < arr[min]){         // if found --> swap it with first element
                    min =j;
                }
            }
            // swap min element with the first

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }


        

        

    }

}
