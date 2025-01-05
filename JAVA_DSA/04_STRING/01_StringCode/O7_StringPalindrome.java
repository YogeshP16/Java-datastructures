
public class O7_StringPalindrome {
    public static void main(String[] args) {
        String str= "sms";
        String rev= "";
    

        //reverse string
        for(int i=str.length()-1; i>=0; i--){
            rev+= str.charAt(i);
        }
        if(str == rev){

            System.out.println("isPal");
        } else{

            System.out.println("Not pal");
        }



    }

}
