/* 
### **Order-Agnostic Binary Search 

Binary search assumes the array is sorted, 
but sometimes we don’t know whether the array is sorted in **ascending** or **descending** order. 
**Order-Agnostic Binary Search** works in both cases.

---

### **How it Works (Steps):**

1. **Check the order**:  
   Compare the first and last elements of the array to determine if it's sorted in ascending or descending order.

2. **Search**:  
   Follow these rules:
   - If the array is **ascending**:
     - Target < Middle → Search **left half**.
     - Target > Middle → Search **right half**.
   - If the array is **descending**:
     - Target < Middle → Search **right half**.
     - Target > Middle → Search **left half**.

3. Repeat until:
   - Target is found.
   - Array is empty (target doesn't exist).

---

### **Key Features:**
- **Works for any sorted order**: Ascending or descending.
- **O(log n)** time complexity.
- Constant **O(1)** space complexity.

---

### **Quick Example (Find 9):**

#### Ascending Array: [1, 4, 7, 9, 11]
1. Middle = 7 → 9 > 7 → Look at [9, 11].
2. Middle = 9 → Found it!

#### Descending Array: [11, 9, 7, 4, 1]
1. Middle = 7 → 9 > 7 → Look at [11, 9].
2. Middle = 9 → Found it!

---

*/


public class OO1_Order_Agnostic_BS {
    static int order_Agnostic_BS(int[] arr, int  target){

        int start =0;
        int end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];  // when you dont know the array is increasing or decreasing

        while (start<=end){

            int mid = start + (end -start)/2;  // find mid
            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){                           // sorted is ascending
                if(target < arr[mid]){
                    end = mid-1;
                }else if(target > arr[mid]){
                    start = mid+1;
                }
                
            } else {                              // sorted in descending
                if(target > arr[mid]){
                    end = mid-1;
                } else if(target < arr[mid]){
                    start = mid +1;
                }
            }


        }
        return end;

        
    }

    public static void main(String[] args) {
        int [] arr = { 76,65,54,53,43,32,21,11,5};   // sorted in desc
        int target = 5;
        int res = order_Agnostic_BS(arr, target);
        System.out.println("index found at: "+res);
    }

}
