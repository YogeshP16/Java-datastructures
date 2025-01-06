/*
Given a string and a non-negative int n, return a larger string that is n copies of the original string.


stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
 */

public class O10_StringTimes {
    public static void main(String[] args) {
        System.out.println(stringTimes("hi", 2));  // hihi
    }
    static String stringTimes(String str, int n){
        String res ="";
        for(int i=0; i<n; i++){
            res += str;
        }
        return res;
    }

}
