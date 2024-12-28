import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,3,3,4};
        HashMap<Integer, Integer> res = countfre(arr);
        for(Integer k : res.keySet()){
            System.out.println(k + ":" + res.get(k));
        }
    }

    static HashMap<Integer, Integer> countfre(int [] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        return map;
        
    }
}
