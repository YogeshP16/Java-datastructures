
public class O9_StringOccurrence {
    public static void main(String[] args) {
        String str = "abcisabcabcisabsidac abc is abc";
        String target = "abc";
        int count = 0;
        int targetlen = target.length();

        for(int i=0; i<= str.length()-targetlen; i++){
            if(str.substring(i,  i+targetlen).equals(target)){
                count++;
            }

        }
        System.out.println(count);

    }

}
