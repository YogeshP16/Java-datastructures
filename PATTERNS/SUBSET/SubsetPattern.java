import java.util.ArrayList;
import java.util.List;

public class SubsetPattern {  // paattern name --> processed unprocessed pattern

    // Recursive function to explore subsets or combinations
    public static void exploreSubset(int[] nums, int index, List<Integer> processedSubset) {
        // Base case: When all elements have been processed
        if (index == nums.length) {
            // Process the current subset (e.g., print or store it)
            System.out.println(processedSubset);
            return;
        }

        // **Include** the current element in the subset
        processedSubset.add(nums[index]);
        exploreSubset(nums, index + 1, processedSubset);

        // **Exclude** the current element from the subset
        processedSubset.remove(processedSubset.size() - 1);
        exploreSubset(nums, index + 1, processedSubset);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};  // Example input
        exploreSubset(nums, 0, new ArrayList<>());
    }
}

