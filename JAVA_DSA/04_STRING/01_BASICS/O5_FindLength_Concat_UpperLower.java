
public class O5_FindLength_Concat_UpperLower {
    public static void main(String[] args) {
        String str = "Hello";
        String str1 = "World";

        System.out.println("String length: "+str.length());  // 5
        System.out.println(str.toLowerCase()); //hello
        System.out.println(str.toUpperCase()); //HELLO
        System.out.println(str+str1); //HelloWorld

    }

}
