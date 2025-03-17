public class O02_ReverseSubString {
    public static void main(String[] args) {
        String s = "abcdefghijk";
        int i = 0;
        int j = 4;
        System.out.println(reverseSubString(s, i, j));  // edcbafghijk
    }
    static String reverseSubString(String s, int i, int j){
        char[] arr = s.toCharArray();

        while (i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return new String(arr);

    }

}
