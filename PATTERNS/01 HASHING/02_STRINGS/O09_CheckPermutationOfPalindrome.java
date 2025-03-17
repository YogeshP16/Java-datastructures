/*
Check if a string is a permutation of a palindrome.

Input: "Tact Coa"
Explanation: The string is a permutation of "taco cat", which is a palindrome.
Output: true

Input: "hello"
Explanation: No permutation of "hello" forms a palindrome.
Output: false


ALGOOoo
Convert to lowercase and remove non-alphabetic characters.
Use a HashMap to count character frequencies.
Traverse the HashMap and count characters with odd frequencies.
If more than one odd frequency, return false.:
Return true if at most one character has an odd frequency.

 */

import java.util.HashMap;

public class O09_CheckPermutationOfPalindrome {
    public static void main(String[] args) {
        String s ="hello";
        boolean res = CheckPermutationPalindrome(s);
        System.out.println(res);
        
    }
    static boolean CheckPermutationPalindrome(String s){
        HashMap <Character, Integer> map = new HashMap<>();

        s = s.toLowerCase().replaceAll("[^a-z ]", "");   // convert to lowercase & remove space

        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        // If more than one odd frequency, return false
        int count_odd = 0;
        for(int freq : map.values()){
            if(freq % 2 != 0){
                count_odd++;
                if(count_odd > 1) return false;
            }
        }
        return true;


    }

}
