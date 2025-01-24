import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 8, 1, 6};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                System.out.println(i+1); // The missing number
            }
        }
    }
}
