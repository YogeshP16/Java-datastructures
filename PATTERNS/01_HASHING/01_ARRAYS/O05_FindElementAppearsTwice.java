import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class O05_FindElementAppearsTwice {
    public static void main(String[] args) {
        int [] arr = { 1,1,2,2,3,4,5};
        List<Integer> res = findTwicee(arr);
        System.out.println(res);
        
    }
    // optimized
    static List<Integer> findTwice(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == 2){
                list.add(i);

            }
        }
        return list;
        
    }
    // brute --->o(n2) sc -->o(n)
    static List<Integer> findTwicee(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();    

        for(int i=0; i < arr.length; i++){
            int count =0;

            for(int j=0; j < arr.length; j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            map.put(arr[i], count);
        }
        List<Integer> list = new ArrayList<>();
        for(int num: arr){
            if(map.get(num) == 2 && !list.contains(num)){
                list.add(num);
            }
        }
        return list;

    }


}
