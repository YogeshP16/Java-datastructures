import java.util.HashMap;

public class O04_FindAllUniqueCharacters {
    public static void main(String[] args) {
        String s= "abc";
        System.out.println(findAllUnique(s));   // true
    }
    // OPTIMIZED
    static boolean findAllUniquee(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c) > 1){
                return false;
            }
        }
        return true;
    }

    // brute force
    static boolean findAllUnique(String s){
        for(int i=0; i< s.length(); i++){
            for(int j=i+1; j< s.length(); j++){
                if(s.charAt(j) == s.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
