
public class O8_CharacterOccurrence {
    public static void main(String[] args) {
        String str = "fnknsfdbfkjdfkjdfbbd";
        char ch = 'f';
        int count =0;

        for(int i=0; i<str.length(); i++){
            if(ch == str.charAt(i)){
                count++;
            }
        }
        System.out.println("f occurrence is: " +count);  // 5
    }

}

