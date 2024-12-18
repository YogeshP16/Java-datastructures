public class O02_ReverseString {
    public static void main(String[] args) {
        String s = "abcd";
        String res = reverse(s);
        System.out.println(res);    
    }

    static String reversee(String s){

    char [] arr = s.toCharArray();  // store each characters in char array

    int left  =0;
    int right = arr.length-1;

    while(left < right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
    return new String(arr);

    }
// brute
    static String reverse(String s){
        String res = "";
        for(int i = s.length()-1; i>=0; i--){
            res += s.charAt(i);
        }
        return res;
    }

}
