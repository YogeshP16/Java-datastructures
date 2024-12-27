import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O03_Conversions {
    public static void main(String[] args) {
        // List to array
    List <Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);

    int[] arr = listConversion(list);
    for(int num:  arr){
        System.out.print(num + " ");
    }

    System.out.println();

        // Map to array 
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1,10);
    map.put(2,20);
    map.put(3,30);

    int[] arr1 = mapConversion(map);
    for(int i: arr1){
        System.out.print(i +" ");
    }
    
        
    }
    static int[] listConversion(List<Integer> list){
        int[] res = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            res[i] = list.get(i);

        }
        return res;
    }

    static int[] mapConversion(Map<Integer, Integer> map){
        int[] res = new int[map.size()];
        int index =0;
        for(int key : map.keySet()){
            res[index++] = key;
        }
        return res;

        /* ------> to return value
        int index =0;
        for(int value : map.value()){
            res[index++] = value;
        }
        return res;
        */
    }

    

}
