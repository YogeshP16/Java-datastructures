import java.util.HashSet;

/**
 * The O00_FindSum class provides a method to check if there exists any element in the array
 * such that its double is also present in the array.
 */
public class O00_FindSum {
    static boolean isPresent(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int i : arr) {
            // Check if double of current number is already in the set
            if (set.contains(i * 2)) {
                return true;  // Found the doubled element
            }
            // Add current number to the set for future checks
            set.add(i);
        }
        
        return false;  // No doubled element found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 6};
        boolean result = isPresent(arr);
        System.out.println("Doubled element exists: " + result);
    }
}
