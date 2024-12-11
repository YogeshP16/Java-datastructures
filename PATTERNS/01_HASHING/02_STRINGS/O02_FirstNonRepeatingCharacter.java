/* 
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0

Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index./*

 */

import java.util.HashMap;

public class O02_FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s= "hhello";
        System.out.println("Index: "+ findUniquee(s));     // index -> 2 --> e --> is non repeating charater
        
    }
    // optimized
    static int findUniquee(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);

        }
        for(char i : s.toCharArray()){
            if(map.get(i) ==1){
                return s.indexOf(i);
            }
        }
        return-1;
    }

    // brute force tc --> o(n2)
    static int findUnique(String s){
        HashMap <Character, Integer> map = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            int count =0;
            for(int j=0; j< s.length(); j++){
                if(s.charAt(j) == ch){
                    count++;
                }
            }
            map.put(ch, count);
        }
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(map.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }

    

}
