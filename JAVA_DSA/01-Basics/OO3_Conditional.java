
public class OO3_Conditional {
    public static void main(String[] args) {


        /* Conditional
        - if
        - if else
        - if else if
        - switch
        - ternary */ 

        int input = 34;
        if (input < 50){
            System.out.println("number is lesser");
        } else if (input == 34){
            System.out.println("number is equal");
        } else {
            System.out.println("numberr is greater");;
        }

// Switch

        int day = 2;
        switch (day) {
            case 1: System.out.println("Monday");      
            break;

            case 2: System.out.println("tuesday");
            break;
            
            case 3: System.out.println("wednesday");
            break;

        
            default: System.out.println("Invallid");
            break;

        }


// Ternary
// variable = (condition)? value if true: value if false;

        int num = 12;
        String res = (num > 10) ? "greater than 10" : " lesser than 10";
        System.out.println(res);



    }

}
