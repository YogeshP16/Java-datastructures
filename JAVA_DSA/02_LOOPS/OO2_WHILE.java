
public class OO2_WHILE {
    public static void main(String[] args) {
        

    // print 1 to 10
    System.out.println("print 1 to 10");
    int i =1;
    while (i<=10){
        System.out.print(i+" ");
        i++;
    }
    System.out.println(" ");




    // print odd number
    System.out.println("print odd number");
    int j =1;
    while (j<=10){
        System.out.print(j +" ");
        j+=2;
    }
    System.out.println(" ");




    // print even number
    System.out.println("print even");
    int k = 2;
    while (k <= 10){
        System.out.print(k+" ");
        k+=2;
    }
    System.out.println(" ");




    //print reverse
    System.out.println("print reverse");
    int l = 10;
    while (l >= 1){
        System.out.print(l + " ");
        l--;
    }
    System.out.println(" ");



    // Do- while loop

    System.out.println("Do-While LOOP");
    int in = 1;
    do {
        System.out.print(in + " ");
        in++;
    } while (in <= 10);


    //System.out.println(" ");

    }

}

/*
print 1 to 10
1 2 3 4 5 6 7 8 9 10 

print odd number
1 3 5 7 9

print even
2 4 6 8 10

print reverse
10 9 8 7 6 5 4 3 2 1

Do-While LOOP
1 2 3 4 5 6 7 8 9 10 
*/