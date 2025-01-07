/*
Given a string and a non-negative int n, return a larger string that is n copies of the original string.
stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"


Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, 
or whatever is there if the string is less than length 3. Return n copies of the front;
frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"
 */

public class O10_StringTimes {
    public static void main(String[] args) {
        System.out.println(stringTimes("hi", 2));  // hihi

        System.out.println(frontTimes("Chocolate", 2));  // ChoCho
    }



    static String stringTimes(String str, int n){
        String res ="";
        for(int i=0; i<n; i++){
            res += str;
        }
        return res;
    }




    static String frontTimes(String str,  int n){
        String res ="";

        String sub = str.length() < 3 ? str : str.substring(0,3);

        for(int i=0; i<n; i++){
            res += sub;
        }
        return res;

    }


}
