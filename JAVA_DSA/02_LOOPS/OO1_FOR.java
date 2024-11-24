
public class OO1_FOR {
    public static void main(String[] args) {

        /*  
        for (int; condition; inc/dec){
        } */
        

        // Print 1 to 10
        System.out.println("print 1 to 10");

        for (int i = 1; i<=10; i++){
            System.out.print( i + " " );
        }
        System.out.println(" ");


        // Print odd numbers
        System.out.println("print odd");

        for (int j = 1; j <= 10; j+=2){
            System.out.print(j + " ");
        }
        System.out.println(" ");


        // Print Even
        System.out.println("print even");

        for (int k =1 ; k <=10; k++){
            if (k%2 ==0){
                System.out.print(k + " ");
            }
        }
        System.out.println(" ");


        // print reverse
        System.out.println("print rerverse");

        for(int i = 10; i>= 1; i--){
            System.out.print(i + " ");
        }
        System.out.println(" ");


        /*

        For each  loop --> enhanced for loop

        for (type of var : collection){
            body
        }

        */
        System.out.println("For each loop");
        int [] numbers = {1,2,3,4,5};
        for (int num : numbers){
            System.out.print(num + " ");
        }



    }

}

/* 
print 1 to 10
1 2 3 4 5 6 7 8 9 10

print odd
1 3 5 7 9

print even
2 4 6 8 10

print rerverse
10 9 8 7 6 5 4 3 2 1 

For each loop
1 2 3 4 5

*/