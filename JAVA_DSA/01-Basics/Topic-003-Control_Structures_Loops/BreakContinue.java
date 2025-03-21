public class BreakContinue {
    public static void main(String[] args) {

    // Break - continue

    int a = 3;
    for(int j = 0; j <= n; j++) {
        if(j == a) break;
        System.out.print(j + " ");  // Output: 0 1 2
    }
    System.out.println();
    

    for(int k = 0; k <= n; k++) {
        if(k == a) continue;
        System.out.print(k + " ");  // Output: 0 1 2 4 5
    }
    System.out.println();

    }

}
