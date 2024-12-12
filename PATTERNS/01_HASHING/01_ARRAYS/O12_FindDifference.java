import java.util.HashSet;

public class O12_FindDifference {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        HashSet<Integer> res = difference(a, b);
        System.out.println(res);
    }

    static HashSet<Integer> difference(int[] a, int[] b) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add elements of array 'a' to set1
        for (int i : a) {
            set1.add(i);
        }

        // Add elements of array 'b' to set2
        for (int i : b) {
            set2.add(i);
        }

        // Create a new set 'res' to store difference from set1
        HashSet<Integer> res = new HashSet<>(set1);
        res.removeAll(set2); // Elements in set1 but not in set2

        // Create a new set 'res2' to store difference from set2
        HashSet<Integer> res2 = new HashSet<>(set2);
        res2.removeAll(set1); // Elements in set2 but not in set1

        // Add all elements from res2 to res
        res.addAll(res2);

        return res; // Return the set containing elements in one but not the other
    }
}
