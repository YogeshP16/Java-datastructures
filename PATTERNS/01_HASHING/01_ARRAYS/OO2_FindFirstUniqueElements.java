/*
 * find first unique element -->  23,23,23,5,23,6,6,6,6
 * output ---> 5  --> value dont have any occurrence
 */



import java.util.HashMap;
public class OO2_FindFirstUniqueElements {
    public static void main(String[] args) {
        int[] arr = {23,23,23,5,23,6,6,6,6};

        System.out.println(findUnique(arr));        // 5
        System.out.println(find_Unique(arr,4));   // 5
    }   
                
    public static int find_Unique(int[]arr, int k){
    int n= arr.length;
    for(int i=0; i< n; i++){
        boolean isunique = true;
    
        for(int j=0; j< n; j++){
            if( i!= j && arr[i] == arr[j]){
                isunique = false;
                break;
        
            }
        }
        if (isunique){
            return arr[i];
        }
    }
    return -1;
    }

    static int findUnique(int[]arr){
        HashMap<Integer, Integer> count = new HashMap<>();

        for(Integer i: arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }


        for(Integer key : count.keySet()){
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
