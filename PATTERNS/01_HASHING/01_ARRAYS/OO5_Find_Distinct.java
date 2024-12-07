/*
input: arr[] = [2, 2, 3, 2]
Output: 2
Explanation: Distinct elements are {2, 3}
 */



import java.util.ArrayList;
import java.util.HashSet;

public class OO5_Find_Distinct {
    public static void main(String[] args) {
        int[] arr ={10, 20, 20, 10, 30, 10, 40, 40};
        int res = findUnique(arr);
        System.out.println(res);
    }

        static int findUnique(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            
            // Iterate over the array
            for (int i = 0; i < arr.length; i++) {
                boolean isUnique = true;
                
                // Compare current element with all other elements
                for (int j = 0; j < list.size(); j++) {
                    // If a duplicate is found, set isUnique to false and break
                    if (arr[i] == list.get(j)) {
                        isUnique = false;
                        break;
                    }
                }
                
                // Add the element to the list if it is unique
                if (isUnique) {
                    list.add(arr[i]);
                }
            }
            
            // Return the count of distinct elements
            return list.size();
        }
    
    

    static int findUnique1(int[] arr){
        HashSet <Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        return set.size();
    }

}
