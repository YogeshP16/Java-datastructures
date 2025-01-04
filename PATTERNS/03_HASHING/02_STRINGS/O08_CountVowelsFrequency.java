import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class O08_CountVowelsFrequency {
    public static void main(String[] args) {
        String s = " hello world";
        Map<Character, Integer> result = countVowelsFreq(s);
        System.out.println(result);

    }
    static Map<Character, Integer> countVowelsFreq(String s){
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }
        return map;
    }

}
