public class O04_TwoSumSorted {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        int target = 7;

        int[] res = twoSum(arr, target);

        if (res != null) {
            System.out.println("Indices: " + res[0] + ", " + res[1]);    // Indices: 2, 3
        } else {
            System.out.println("No solution found");
        }
        
    }
    static int[] twoSum(int[] arr, int target){
        int left  =0;
        int right = arr.length-1;

        while(left<right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                return new int[] {left, right};
            } else if (sum < target){
                left++;
            } else{
                right--;
            }
        }
        return new int[] {-1, -1};

    }
    

}

