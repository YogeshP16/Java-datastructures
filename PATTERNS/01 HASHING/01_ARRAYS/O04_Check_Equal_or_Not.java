import java.util.Arrays;
import java.util.HashMap;

public class O04_Check_Equal_or_Not {
    public static void main(String[] args) {
        int[] arr1 = {5,5,5,3,2,1};
        int[] arr2 = {3,2,1,5,5,5};
        boolean res = checkEquals1(arr1, arr2);
        System.out.println(res);
    }

    /*
     * sort both arrays
     * iterate --> if arr1 not equal to arr2 return false
     */
    static boolean checkEquals(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    
    } 


    /*
     * create two map res, res1
     * iterate both and count the occurrence and store it to the both res, res1 map.
     * if res equals re1 --> it return true else false;
     */
    static boolean checkEquals1(int[] arr1, int[] arr2){
        HashMap <Integer, Integer> res = new HashMap<>();
        HashMap <Integer, Integer> res1 = new HashMap<>();

        for(Integer i: arr1){
            res.put(i, res.getOrDefault(i, 0)+1);
        }
        for(Integer j: arr2){
            res1.put(j, res1.getOrDefault(j, 0)+1);
        }
       
        
        return res.equals(res1);
        


        


    }

}
