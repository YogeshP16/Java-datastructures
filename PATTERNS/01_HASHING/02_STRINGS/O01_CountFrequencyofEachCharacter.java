import java.util.HashMap;
import java.util.Map;

public class O01_CountFrequencyofEachCharacter {
    public static void main(String[] args) {
        String s = "Heythere";
        Map<Character, Integer> charCount = countCharacterss(s);

        for(Character key : charCount.keySet()){
            System.out.print( key + ":" + charCount.get(key) + " ");   // r:1 t:1 e:3 H:1 h:1 y:1 
        }
       
    }

    static HashMap<Character, Integer> countCharacters(String s){

        HashMap <Character, Integer> map = new HashMap<>();

        // traverse each character in string
        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);

            // count occurrence of ch in string
            int count =0;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == ch){
                    count++;
                }
            }
            
            map.put(ch, count);
        }

        return map;

    }

    // optimized tc --> O(n)

    static HashMap<Character, Integer> countCharacterss(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        return map;
    }

}
