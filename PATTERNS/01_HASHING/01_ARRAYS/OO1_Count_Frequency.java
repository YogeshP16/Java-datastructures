import java.util.HashMap;
import java.util.Map;

public class OO1_Count_Frequency {
    public static void main(String[] args) {
        int[] arr = {1,1,1,22,2,2,2,4,4,5,6,6,6,6,7};

        //String res = countDuplicates(arr);
        //System.out.println(res);
        
        Map<Integer, Integer> result =countFreq(arr);
        for (Integer key : result.keySet()) {
            System.out.print(key + ":" + result.get(key) + " ");
        }

        
        
    }

    

    // Brute force --> tc- O(n2) sc-o(1)

    static String countDuplicates(int[] arr){
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
            if(arr[i] != -1 && count > 1){
                res.append(arr[i] +":"+ count + " ");
            }
          
        }
        return res.toString();
    }






    // Optimized tc - O(n), sc- O(n)
    
    
    static Map<Integer, Integer> countFreq(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();

        // getOrDefault---> get the current count, defaulting to 0, and increment by 1

        for(Integer i : arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        return count;
        
    }

}
