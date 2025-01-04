import java.util.HashMap;
/*
Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
 
 
countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
 */
public class O10_CountStringXX {
    public static void main(String[] args) {
 
        System.out.println(countXX("abcxx"));  // 1
        System.out.println(countXX("abcxxx"));  // 2
        System.out.println(countXX("abcxxxx"));  // 3
        
    }
    static int countXX(String s){
        HashMap<Integer, Boolean> map = new HashMap<>();

        int count =0;

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == 'x' && s.charAt(i+1) == 'x'){
                map.put(i, true);
                count++;
            }
        }
       // System.out.println("Map:" + map);
        return count;
    }
    

}
