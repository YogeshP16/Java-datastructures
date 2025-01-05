/*
Given a string, return a string made of the first 2 chars (if present), however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".


startOz("ozymandias") → "oz"
startOz("bzoo") → "z"
startOz("oxx") → "o"
 */

public class O08_StartOZ {
    public static String startOz(String str) {
        String result = ""; // Initialize an empty string for the result

        // Check if the first character exists and is 'o'
        if (str.length() > 0 && str.charAt(0) == 'o') {
            result += str.charAt(0);
        }

        // Check if the second character exists and is 'z'
        if (str.length() > 1 && str.charAt(1) == 'z') {
            result += str.charAt(1);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(startOz("ozymandias")); // Output: "oz"
        System.out.println(startOz("bzoo"));       // Output: "z"
        System.out.println(startOz("oxx"));       // Output: "o"
        System.out.println(startOz("hello"));     // Output: ""
        System.out.println(startOz("oz"));        // Output: "oz"
        System.out.println(startOz("o"));         // Output: "o"
        System.out.println(startOz("z"));         // Output: ""
    }
}
