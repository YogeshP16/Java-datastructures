
import java.util.HashMap;
import java.util.Set;


public class OO1_Find_First_Unique_Elements {
    public static void main(String[] args) {
        int[] arr = {23,23,23,5,23,23,6,6,6};
        System.err.println(findUnique(arr));


        
    }
    static int findUnique(int[]arr){
        HashMap<Integer, Integer> count = new HashMap<>();

        for(Integer i: arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }

        Set<Integer> keys =count.keySet();
        for(Integer key : keys){
            if(count.get(key)==1){
                return key;
            }
        }
        return -1;



        /*
         
        other way to traverse map and get the value


         for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
            return entry.getKey();
            }

        }
        return -1;
         */
        
    }

}
