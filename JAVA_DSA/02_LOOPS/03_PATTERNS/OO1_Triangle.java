public class OO1_Triangle {
    
/*

* * * * 
* * * *
* * * *
* * * *

*/

    static int box(int n){
        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
                return n;
    }
  
/*

*
* *
* * *
* * * *

 */
    static int triangle(int n){
        for(int i=0; i< n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*" +" ");
            }
            System.out.println();
        }
        return n;

    }
/*

1
2 2
3 3 3
4 4 4 4

 */
    static int triangle1(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i +" ");
            }
            System.out.println();
        }
        return n;

    }
/*
 
1
1 2 
1 2 3
1 2 3 4
 */
    static int triangle2(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<i+1; j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
        return n;

    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(box(n));
        System.out.println(triangle(n));
        System.out.println(triangle1(n));
        System.out.println(triangle2(n));
        
        
    }

}
