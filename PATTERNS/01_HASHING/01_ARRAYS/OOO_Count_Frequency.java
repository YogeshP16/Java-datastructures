import java.util.HashMap;
import java.util.Map;

public class OOO_Count_Frequency {
    public static void main(String[] args) {
        int[] arr = {1,1,1,22,2,2,2,4,4,5,6,6,6,6,7};
        Map<Integer, Integer> res =countFreq(arr);
        System.out.println(res);
        
    }
    static Map<Integer, Integer> countFreq(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();

        // getOrDefault---> get the current count, defaulting to 0, and increment by 1

        for(Integer i : arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        return count;

    }

}
