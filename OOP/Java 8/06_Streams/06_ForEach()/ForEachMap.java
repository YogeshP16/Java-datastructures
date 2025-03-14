import java.util.HashMap;
import java.util.Map;

public class ForEachMap {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<Integer, Person>();
        map.put(1, new Person(3,"Zeke", "EEE"));
        map.put(2, new Person(4,"ace", "Ece"));

        for(Map.Entry<Integer, Person> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getName());
        }

        //usinf java 8
        map.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v.getName());
        });

        

        
    }

}
