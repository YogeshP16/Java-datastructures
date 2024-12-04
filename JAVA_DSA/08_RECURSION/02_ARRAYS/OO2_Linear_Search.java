import java.util.ArrayList;
import java.util.List;

public class OO2_Linear_Search {

    public static void main(String[] args) {
        int [] arr = {1,23,23,23,4,5,6,7};
        int target = 23;
        System.out.println(linear(arr, target, 0));                // true
        System.out.println(linearIndex(arr, target, 0));           // 1  ---> find first occurrence of target
        System.out.println(linearLastIndex(arr, target, arr.length-1));  // 3 --> find last occurrence of target
        linearAllIndex(arr, 23, 0);
        System.out.println(list);                                        // [1, 2, 3]

        findALLIndex(arr, 23, 0);
        System.out.println(list); 

    }


    // Return true if index found else false

    static boolean linear(int[] arr, int target, int index){
        if(index == arr.length) return false;
        return arr[index] == target || linear(arr, target, index+1); 
    }



    // return first index if found else -1

    static int linearIndex(int[] arr, int target, int index){
        if(index == arr.length) return -1;

        if( arr[index] == target){
             return index;
        } else {
            return linearIndex(arr, target, index+1);

        }
    }
    
    // return last index occurence if target found else -1

    static int linearLastIndex(int [] arr, int target, int index){
        if(index == -1) return -1;

        if( arr[index] == target){
             return index;
        } else {
            return linearLastIndex(arr, target, index-1);

        }
    }


    // return all index occurence if target found else -1

    static List<Integer> list = new ArrayList<>();
    static void linearAllIndex(int [] arr, int target, int index){
        if(index == arr.length) return ;

        if( arr[index] == target){
             list.add(index);
        } 

        linearAllIndex(arr, target, index+1);
    }

    // return type will be list without passing list arg to the parameter --> find target

    static List<Integer> findALLIndex(int[] arr, int target, int index) {
        // Create a new list to store indices where the target is found
        List<Integer> l = new ArrayList<>();
    
        // Base case: If we've reached the end of the array, return the empty list
        if (index == arr.length) return l;
    
        // If the current element matches the target, add its index to the list
        if (arr[index] == target) {
            l.add(index);
        }
    
        // Recursively call the method for the rest of the array
        List<Integer> answersfrombelowcalls = findALLIndex(arr, target, index + 1);
    
        // Combine the indices from the current call with those from the recursive calls
        l.addAll(answersfrombelowcalls);
    
        // Return the combined list
        return l;
    }
      
}
