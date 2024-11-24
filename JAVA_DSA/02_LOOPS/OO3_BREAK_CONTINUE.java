
public class OO3_BREAK_CONTINUE {

    public static void main(String[] args) {
        
        // FOR WITH BREAK
        System.out.println("FOR WITH BREAK ");

        for(int i = 1; i<= 10; i++){
            if(i == 5){
                break; // it print 1 to 4
            }
            System.out.print(i + " ");
        }

        System.out.println(" ");


        // FOR WITH CONTINUE
        System.out.println("FOR WITH CONTINUE ");

        for(int i = 1; i<=10; i++){
            if(i==5){
                continue;  // it skip 5 and print all numbers
            }

            System.out.print(i + " ");
        }

        System.out.println(" ");



        // WHILE WITH BREAK
        System.out.println("WHILE WITH BREAK ");

        int i =1 ;
        while(i<=10){
            if(i==5){
                break;
            }
            System.out.print(i+" ");
            i++;
        }
        System.out.println(" ");

        // WHILE WITH CONTINUE
        System.out.println("WHILE WITH CONTINUE ");
        int in=1;
        while(in<=10){
            if(in==5){
                in++;
                continue;
            }
            System.out.print(in + " ");
            in++;
        }

        System.out.println(" ");

        //Print EVEN
        System.out.println("Print EVEN");
        int x=1;
        while(x<=10){
            if(x % 2 != 0){
                x++;
                continue;

            }
            System.out.print(x+ " ");
            x++;


        }

        System.out.println(" ");


    }

}
/*
FOR WITH BREAK 
1 2 3 4

FOR WITH CONTINUE
1 2 3 4 6 7 8 9 10

WHILE WITH BREAK
1 2 3 4

WHILE WITH CONTINUE
1 2 3 4 6 7 8 9 10

Print EVEN
2 4 6 8 10 

*/