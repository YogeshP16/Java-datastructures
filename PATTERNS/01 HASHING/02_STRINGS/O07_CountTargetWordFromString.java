import java.util.HashMap;

public class O07_CountTargetWordFromString {
    public static void main(String[] args) {

        String s = "Ram and ramya going to ramapuram";
        String target = "ram";

        HashMap<String, Integer> res = countWords(s, target);
        System.out.println(target + ":" + res.get(target));      // 4 times ram occurs in string s
    }
    static HashMap<String, Integer> countWords(String s, String target){
        
        HashMap<String, Integer> map = new HashMap<>();
        s = s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        target = target.toLowerCase();

        String [] words = s.split("\\s+");


       
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
            if(word.contains(target)){
                map.put(target, map.getOrDefault(target, 0) + 1);
              
            }  
        }
        return map;
    }

}
