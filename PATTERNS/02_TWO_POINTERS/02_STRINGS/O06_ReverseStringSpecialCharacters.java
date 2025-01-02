public class O06_ReverseStringSpecialCharacters {
    public static void main(String[] args) {
        String s = "Hello@there$how%";
        System.out.println(reverseStringWithoutReplace(s));  // woher@ehtol$leH%
    }
    static String reverseStringWithoutReplace(String s){
        char[] arr = s.toCharArray();

        int l =0;
        int r = arr.length-1;

        while(l<r){
            if(!isAlphanumeric(arr[l])){
                l++;
            } 
            else if (!isAlphanumeric(arr[r])){
                r--;
            } else{
                swap(arr, l, r);
                    l++;
                    r--;
                
            }
        }
        return new String(arr);

    }
    private static boolean isAlphanumeric(char ch){
        return Character.isLetterOrDigit(ch);

    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
