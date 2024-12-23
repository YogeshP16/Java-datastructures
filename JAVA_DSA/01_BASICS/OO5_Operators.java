public class OO5_Operators {
/*
Operators 

What are Operators?
symbols used to perform operations on variables and values.

Types of Operator
-------------------
Arithmetic Operators
--------------------
Used for basic math operations.

+ (Addition)
- (Subtraction)
* (Multiplication)
/ (Division)
% (Modulus)

Relational (Comparison) Operators
---------------------------------
Used to compare two values.

== (Equal to)
!= (Not equal to)
> (Greater than)
< (Less than)
>= (Greater than or equal to)
<= (Less than or equal to)

Logical Operators
-----------------
Used to combine conditional statements.
 
&& (AND)   --> check for both condition will be true
|| (OR)    --> any of one condition true --> returns true
! (NOT)    --> vice versaaa

Assignment Operators
--------------------
Used to assign values to variables.

= (Assign)
+= (Add and assign)
-= (Subtract and assign)
*= (Multiply and assign)
/= (Divide and assign)
%= (Modulus and assign)

Unary Operators
----------------
Used on a single operand.

+ (Unary plus)
- (Unary minus)
++ (Increment)
-- (Decrement)
! (Logical NOT)

Bitwise Operators
---------------------
Used to perform bit-level operations.

& (AND)
| (OR)
^ (XOR)
~ (NOT)
<< (Left shift)
>> (Right shift)
>>> (Unsigned right shift)

Ternary Operator
------------------
A shorthand for an if-else statement.

condition ? value_if_true : value_if_false
 */

    public static void main(String[] args) {
        System.out.println("Arithmetic");
        int a = 10;
        int b = 20;

       
        boolean res  =  logical(a, b);
        System.out.println(res);
  

        
    }

    static boolean logical(int a, int b){
        if(a==b && a>b){
            return true;
        } else if (a>b || a==b){
            return true;
        }else if(a!=b){
            return true;
        }
        return false;
    }
    
}
