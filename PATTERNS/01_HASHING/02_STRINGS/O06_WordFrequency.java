import java.util.HashMap;
import java.util.Map;

public class O06_WordFrequency {
    public static void main(String[] args) {
        
        String s = "Hello, there hello hi how are you hi";
        Map<String, Integer> res = countWords(s);
        for(String i: res.keySet()){
            Integer value = res.get(i);
            System.out.println(i + ":" + value);
        }

        String[] w = {"hello", "world", "hello", "everyone", "this", "is", "a", "test", "a", "simple", "test"};
        Map<String, Integer> result = countWordss(w);
        for(String i: result.keySet()){
            Integer value = result.get(i);
            System.out.println(i + ":" + value);
        }

        
    }
    // count freq in string
    static Map<String, Integer> countWords(String s){

        /* convert to lowercase
        [^a-zA-Z ]
        ^ inside the square brackets means "NOT".
        a-zA-Z matches all English alphabet letters (both uppercase and lowercase).
        (space) is included to allow spaces in the string.
        0-9 it include numbers 
         */
        s = s.replaceAll("[^a-zA-z0-9 ]", "").toLowerCase();

        // split the string into words
        String[] words = s.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        return map;
        
    }

    // count fre in array
    static Map<String, Integer> countWords(String[] w){

        HashMap<String, Integer> map = new HashMap<>();
        for(String word : w){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        return map;
    }


    // Brute force code
    static Map<String, Integer> countWordss(String[] w){ 
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : w){
            if(map.containsKey(word)){
                map.put(word, map.get(word) +1);
            } else {
                map.put(word, 1);
            }

        }
        return map;
    }


}
