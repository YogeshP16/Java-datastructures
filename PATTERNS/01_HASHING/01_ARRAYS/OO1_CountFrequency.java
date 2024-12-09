import java.util.HashMap;
import java.util.Map;

public class OO1_CountFrequency {
    public static void main(String[] args) {
        int[] arr = {1,1,1,22,2,2,2,4,4,5,6,6,6,6,7};

        // to print result where count > 1
        String res = countfreq(arr);
        System.out.println(res);    // 1:3 2:3 4:2 6:4 
        

        //  to print result 
        Map<Integer, Integer> result =countNumbers(arr);
        for (Integer key : result.keySet()) {
            System.out.print(key + ":" + result.get(key) + " ");    // 1:3 2:3 4:2 5:1 22:1 6:4 7:1
        }

        // to print result where count > 1 in hashmap
        Map<Integer, Integer> result1 =countFreq(arr);
        for (Integer key : result1.keySet()) {
            if(result1.get(key) > 1){
                System.out.print(key + ":" + result1.get(key) + " ");   // 1:3 2:3 4:2 6:4 
            } 
        }
        
    }

    // Brute force --> tc- O(n2) sc-o(1)

    static String countfreq(int[] arr){
        int n = arr.length;
        StringBuilder  res = new StringBuilder();;
        for(int i=0; i<n; i++){
            int count =1;
            for(int j=i+1; j<n; j++){
                if(arr[i] ==  arr[j]){
                    count ++;
                    arr[j] =-1;

                }
            }
            if(arr[i] != -1 && count > 1){               // it print count occurrence more than 1 
                res.append(arr[i] +":"+ count + " ");    // 1:3 2:3 4:2 6:4 
            }
          
        }
        return res.toString();
    }

    static HashMap<Integer, Integer> countNumbers(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Loop over each number in the array
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            // Compare the number at index i with every other index in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            // Add the number and its count into the HashMap
            map.put(arr[i], count);
        }
        return map;
    }



    // Optimized tc - O(n), sc- O(n)
    static Map<Integer, Integer> countFreq(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();

        // getOrDefault---> get the current count, defaulting to 0, and increment by 1
        // iterating arr and add it to count (Hashmap)
        for(Integer i : arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        
        return count;
        
    }

}
