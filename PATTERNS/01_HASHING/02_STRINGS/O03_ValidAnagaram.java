import java.util.HashMap;

public class O03_ValidAnagaram {
    public static void main(String[] args) {
        String s = "/*a1D";
        String t = "/*a1D";

        System.out.println(isAnagramm(s,t));
        
    }
    // optimized
    static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        
        for(char ch: t.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        return map.equals(map1);
        
    }

    // brute force
    static boolean isAnagramm(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            int count =0;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == ch){
                    count++;
                }
            }
            map.put(ch,  count);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);

            int count =0;
            for(int j=0; j<t.length(); j++){
                if(s.charAt(j) == ch){
                    count++;
                }
            }
            map1.put(ch,  count);
        }
        return map.equals(map1);

    }
}


