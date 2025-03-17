import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class O06_MajorityElements {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,3,3,4};
       
        System.out.println(majority(arr));

        List <Integer> res = majorityyy(arr);
        System.out.println(res);
    }

    // optmized
    static int majority(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for(int i : arr){
            map.put(i,  map.getOrDefault(i,0)+1);
            if(map.get(i) > n/2){
                return i;
            }
        }
        return -1;
    }
    
    // BRUTE FORCE
    static int majorityy(int[] arr){
        int n = arr.length;

        for(int i=0; i< n; i++){

            int count =0;
            for(int j =0; j<n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count >= n/2){
                return arr[i];
            }
        }
        return -1;
    }

    public static  List<Integer> majorityyy(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        // Count frequency of each element in the array
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Check for elements that appear more than n/3 times
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                list.add(key);
            }
        }

        return list; // Return the list after processing all elements
    }
    
} 


