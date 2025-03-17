public class O03_ReverseWords {
    public static void main(String[] args) {
        String str = "hello hi This is Yogesh";
        System.out.println(reverseWords(str));  // Output: "olleh ih siht si hsegoy"
    }

    static String reverseWords(String str){
        // Trim any leading or trailing spaces, and then convert to char array
        str = str.trim();
        char[] arr = str.toCharArray();

        int l = 0;
        for(int r = 0; r < arr.length; r++){
            // Check for space or end of string to identify a word
            if(r == arr.length || arr[r] == ' '){
                reverseSubString(arr, l, r - 1);  // Reverse the word
                l = r + 1;  // Move left pointer to start of next word
            }
        }

        // Handle the last word if not already reversed
        reverseSubString(arr, l, arr.length - 1);

        return new String(arr);  // Convert the character array back to string
    }

    // Helper method to reverse a substring in place
    private static void reverseSubString(char[] arr, int l, int r){
        while(l < r){
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;

            l++;
            r--;
        }
    }
}
