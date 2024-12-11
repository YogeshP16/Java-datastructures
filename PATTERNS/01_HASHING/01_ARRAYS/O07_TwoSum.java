import java.util.HashMap;

public class O07_TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        // Handle null/empty result safely
        if (res[0] != -1) {
            System.out.println("Indices: " + res[0] + ", " + res[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
    static int[] twoSum(int[] nums, int target){
        HashMap<Integer,  Integer>map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return  new int[] {-1,-1};

    }

    static int[] twoSumm(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
