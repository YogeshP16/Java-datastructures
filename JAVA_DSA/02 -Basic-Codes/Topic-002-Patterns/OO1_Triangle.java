public class OO1_Triangle {

    /*
    * * * * 
    * * * *
    * * * *
    * * * *
    */
    static void box(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     

    /*
    *
    * *
    * * *
    * * * *
    */
    static void triangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
    1
    2 2
    3 3 3
    4 4 4 4
    */
    static void triangle1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /*
    1
    1 2 
    1 2 3
    1 2 3 4
    */
    static void triangle2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    /*
    * * * *
    * * *
    * *
    *
    */
    static void triangle4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        box(n);
        triangle(n);
        triangle1(n);
        triangle2(n);
        triangle4(n);
    }
}
