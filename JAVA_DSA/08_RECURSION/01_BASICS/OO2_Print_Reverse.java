public class OO2_Print_Reverse {
    public static void main(String[] args) {
        printrev(5);
    }
    static void printrev(int n){
        if(n==0){
            return;
        } else {
            System.out.print(n + " ");   // 5 4 3 2 1 --> it first print then it call the function
            printrev(n-1);
        }
    }

    /*
    
    Step	Function Call	    Condition Check	Action Taken	            Output	    Return to
    1	    printNos(3)	        n > 0	        Print 3, Call printNos(2)	3	        Step 2
    2	    printNos(2)     	n > 0	        Print 2, Call printNos(1)	3 2     	Step 3
    3	    printNos(1)	        n > 0	        Print 1, Call printNos(0)	3 2 1	    Step 4
    4	    printNos(0)	        n <= 0	        Return to previous call	(nothing more)	Step 3
    5	    Resume printNos(1)	End of function	No action	                3 2 1	    Step 2
    6	    Resume printNos(2)	End of function	No action	                3 2 1	    Step 1
    7	    Resume printNos(3)	End of function	No action	                3 2 1	    None
     */

}
