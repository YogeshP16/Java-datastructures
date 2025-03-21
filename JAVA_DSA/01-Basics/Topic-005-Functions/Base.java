import java.util.ArrayList;

public class Base {
    public static void main(String[] args) {
        // Example usage of the new function
        int result = addTwoNumbers(5, 10);
        System.out.println("Sum: " + result);
    }

    static void functionOne(int a){
        //  no return type
    }

    static String functionTwo(String s){
        return "String return type";
    }

    static int[] functionThree(int[] arr){
        return new int[] {};
    }

    static ArrayList<Integer> functionFour(){
        return new ArrayList<>();
    }

    static int addTwoNumbers(int a, int b) {
        return a + b;
    }
}
