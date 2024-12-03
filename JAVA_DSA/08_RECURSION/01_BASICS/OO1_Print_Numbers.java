public class OO1_Print_Numbers {
    public static void main(String[] args) {
        printnums(5);
        print_N(10);
    }
    static void printnums(int n){
        if(n<=0) return; // base condition

        printnums(n-1);  // Hypothesis

        System.out.print(n + " ");  // induction  // 1 2 3 4 5
    }

// use to print  1 to n numbers
    static void print_N(int n){
        if(n<=1) return;
        print_N(--n);  
        System.out.print(n + " ");  // 1 2 3 4 5 6 7 8 9
    }


    /*
    Dry Run for print_N(5)

    Step	Function Call	    Condition Check	    Action Taken	        Output
    1	    print_N(5)	        5 > 0	            Call print_N(4)	
    2	    print_N(4)	        4 > 0	            Call print_N(3)	
    3	    print_N(3)	        3 > 0	            Call print_N(2)	
    4	    print_N(2)	        2 > 0	            Call print_N(1)	
    5	    print_N(1)	        1 > 0	            Call print_N(0)	
    6	    print_N(0)	        0 <= 0	            Return (Base Condition)	
    7	    Resume print_N(1)	Print 1	            Return to print_N(2)	1
    8	    Resume print_N(2)	Print 2	            Return to print_N(3)	1 2
    9	    Resume print_N(3)	Print 3	            Return to print_N(4)	1 2 3
    10	    Resume print_N(4)	Print 4	            Return to print_N(5)	1 2 3 4
    11	    Resume print_N(5)	Print 5	            End	                    1 2 3 4 5

     */

}
