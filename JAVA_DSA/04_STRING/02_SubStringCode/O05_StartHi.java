/*
Given a string, return true if the string starts with "hi" and false otherwise.


startHi("hi there") → true
startHi("hi") → true
startHi("hello hi") → false
 */

public class O05_StartHi {
    public static void main(String[] args) {
        System.out.println(startHi("hi there"));  // true
        
    }
    public static  boolean startHi(String str) {
        if(str.length() < 2){
          return false;
        }
        if(str.substring(0, 2).equals("hi")){
          return true;
        }else{
          return false;
        }
        
      }

}
