import java.util.HashMap;

public class OO2_Hash {
    public static void main(String[] args) {

        // HASH MAP

        HashMap<Integer, String> map = new HashMap<>();


        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");

        System.out.println(map);  //return -->  {1=A, 2=B, 3=C, 4=D}


        // to get the data
        System.out.println(map.get(3));  // return value --> C

        // traverse via entrySet() -->

        for(HashMap.Entry<Integer, String> entry : map.entrySet() ){
            System.out.println("key: "+ entry.getKey() + "-" + "value: " + entry.getValue());

            /*   ouput
                key: 1-value: A
                key: 2-value: B
                key: 3-value: C
                key: 4-value: D
             */
        }

        map.remove(2);                         // remove B
        map.put(2, "newly updated");     // update

         // traverse via keySet()

        for(Integer key : map.keySet()){
            System.out.println("Key: " + key + "-" + "value: " + map.get(key));

            /*
                key: 1-value: A
                key: 2-value: newly updated
                key: 3-value: C
                key: 4-value: D
             */
        }

        
    }



}
