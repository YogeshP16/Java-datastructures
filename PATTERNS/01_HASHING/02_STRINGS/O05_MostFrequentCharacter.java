import java.util.HashMap;

public class O05_MostFrequentCharacter {
    public static void main(String[] args) {
        String s = "aAAAAbccc";
        System.out.println(mostFreq(s));
        
    } // optimized
    static char mostFreq(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.isEmpty()) return '0';

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1 );
        }
        int maxfreq =0;
        char mostfreqchar = '\0';

        for(Character key : map.keySet()){
            if(map.get(key) > maxfreq ){
                maxfreq = map.get(key);
                mostfreqchar = key;

            }
        }
        return mostfreqchar;
    }
    // brute force
    static char mostFreqq(String s){
        char mostfreqchar = '\0';
        int maxfreq = 0;
        
        for(int i=0; i<s.length(); i++ ){
            char ch = s.charAt(i);

            int count =0;
            for(int j=0; j< s.length(); j++){
                if(s.charAt(i) == ch){
                    count++;
                }
            }
            if(count> maxfreq){
                maxfreq = count;
                mostfreqchar = ch;
            }
        }
        return mostfreqchar;
    }

}
