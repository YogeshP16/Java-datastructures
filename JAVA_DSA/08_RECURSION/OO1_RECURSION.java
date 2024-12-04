/*

RECURSION
--------
Function calling itself, solve smaller subpart of same problem, useful to broke problems to sub problems

two things to learn
---------------------
understand funcion calls
base condition (stops infinite loop--> to avoid stack overflow  error)

Internal working 
----------------
each function call added to stack
when base condition met --> the stack rewind(it print output)

Recursion tree
----------------

sum of n numbers --> n + sum(n-1)

          sum(3)
        /        \
3 + sum(2)       return 0 (base condition)
2 + sum(1)
1 + sum(0)


IBH Method: Hypothesis - Induction - Base Condition
-----------------------------------------------------
The IBH Method is a simple way to solve recursion problems step by step. 
Think of it as a magical recipe to make sure your recursion works correctly and is easy to understand.

Breaking Down the IBH Method
----------------------------

Hypothesis:
"What do we assume the recursion will do for us?"
Think of the hypothesis as trusting a helper who can solve the smaller version of the same problem. 
You just believe, "If I ask my helper to do the job for a smaller input, it will be done perfectly."

Example:
If you want to print numbers from 1 to n, 
your helper can already print numbers from 1 to n-1. 
You don’t worry about how the helper does it—you just trust it!

Induction:
"How can I use the helper's solution to solve the current problem?"
This is the part where magic happens. Using the result from the smaller input (the hypothesis), 
you figure out how to solve the problem for the current input.

Example:
If the helper has already printed numbers from 1 to n-1, 
you just need to print the number n after the helper finishes its job. That completes the solution.

Base Condition:
"When should the recursion stop?"
The base condition is the simplest possible problem that can be solved without needing a helper. 
It’s like a signal for recursion to stop. Without it, recursion would go on forever, causing an error!

Example:
If n = 0, there’s nothing to print. That’s our base condition, and we simply return.


Understanding Recursive Tree (IP/OP Method)
---------------------------------------------
The Recursive Tree Method works when you know decisions to make at every step. 
It’s useful for problems like generating all subsets, combinations, or permutations.


When to Use Each Method
-------------------------
IBH Method:
Use it when you don’t have explicit choices to make, but you can reduce the input size step by step. Examples:

Printing numbers
Calculating factorial
Sum of digits

Recursive Tree (IP/OP Method):
Use it when you have clear decisions to make at each step. Examples:

Subsets
Permutations
Combinations
 */

public class OO1_RECURSION {

    public static void main(String[] args) {
        print_N(8);   
        printSubsets("", "ab");
    
    }
    static void print_N(int n){
        if(n <= 0) return;           // Base Condition
        print_N(n-1);                // Hypothesis: Assume it prints numbers from 1 to n-1
        System.out.print(n + " ");   // Induction: Print the current number after the helper
    }

    /*
    How the IBH Method Works:

    Base Condition:
    If n <= 0, there’s nothing to print, so we stop.
    This is the smallest input that cannot be processed further.

    Hypothesis:
    We assume the function can already print numbers from 1 to n-1.
    We don’t worry about how—we just trust it.

    Induction:
    After the helper has printed numbers from 1 to n-1, we print the number n ourselves. This completes the task.
    Output for printNumbers(3):
     */




    //  Recursive tree method

    static void printSubsets(String op, String ip) {
        if (ip.isEmpty()) { // Base Condition
            System.out.println(op); // Print the subset
            return;
        }

        // Decision 1: Exclude the first character
        printSubsets(op, ip.substring(1));
        
        // Decision 2: Include the first character
        printSubsets(op + ip.charAt(0), ip.substring(1));
    }

    /*
    How It Works (IP/OP Method):
    ------------------------------
    Input (IP): The part of the string left to process.
    Output (OP): The subset we’ve built so far.

    Recursive Tree for "ab":
    --------------------------
    Start with ("", "ab")
    Exclude 'a': ("", "b")
    Exclude 'b': ("", "") → Print ""
    Include 'b': ("b", "") → Print "b"
    Include 'a': ("a", "b")
    Exclude 'b': ("a", "") → Print "a"
    Include 'b': ("ab", "") → Print "ab"

    Output:

    ""  
    "b"  
    "a"  
    "ab"
        
    */

}
