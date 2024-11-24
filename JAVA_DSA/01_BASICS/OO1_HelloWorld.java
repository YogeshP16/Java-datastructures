

/*
Declaring Variables in Java:
 
Basics:
Syntax:
Datatype variableName = value;


Data Types:
int → Integer values
float, double → Decimal values
char → Single character
boolean → true/false
long → Larger integer
short → Smaller integer


Variable Rules:
Cannot start with a number.
No spaces or special characters except _.
Cannot use keywords (e.g., int, class).
Case-sensitive (var ≠ Var).


How Data is Stored:
Integers: Stored in binary. Negative values use 2’s complement.
Floats/Doubles: Double by default; use f or F for float.
Example: float x = 10.4f;
Chars: Stored as ASCII codes (e.g., 'a' → 97).


Special Notes:
Adding int to char adds ASCII value:
'a' + 1 → 97 + 1 = 98.


Data Types, Default Sizes, and Ranges in Java:
Datatype	Size	  Range
boolean	1 byte	   true / false
char	2 bytes	   0 to 65,535 (Unicode values)
short	2 bytes	  -32,768 to 32,767
int	    4 bytes	  -2,147,483,648 to 2,147,483,647
long	8 bytes	  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float	4 bytes	  ±1.4E-45 to ±3.4028235E38 (7 decimal digits)
double	8 bytes	  ±4.9E-324 to ±1.7976931348623157E308 (15 decimal digits)


 */

public class OO1_HelloWorld {
    public static void main(String[] args) {

        // Datatypes
        byte b = 23;
        int i = 344335;
        float f = 2.3f;
        double d = 43442423;
        boolean bool = true;
        char c = 's';
        String str = "Hello world";

        System.out.println(str);
        System.out.println(b);
        System.out.println(i);
        System.out.println(f);
        System.out.println(bool);
        System.out.println(c);
        System.out.println(d);
    }
}
