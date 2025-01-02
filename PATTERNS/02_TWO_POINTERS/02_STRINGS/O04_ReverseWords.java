public class O04_ReverseWords {
    public static void main(String[] args) {
        
        String s = " yogesh is  this hey  ";
        System.out.println(reverseWords(s));  // hey this is yogesh 
        
    }
    static String reverseWords(String s){
        String[] words = s.trim().split("\\s+");
        int l =0;
        int r =words.length-1;
        while(l<r){
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }
        return String.join(" ", words);

    }
    

}
