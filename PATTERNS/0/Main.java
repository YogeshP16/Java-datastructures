
/*
 *Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 
You can return the answer in any order.
 
 
Example 1:
 
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

emplyee (emp id 1 to 10000) return employee 3000 to 6000
select emp id from eployee 

*/


public class Main{
    public static void main(String[] args) {
        int [] nums  = {2,7,11,15};
        int target = 9;

        int start = 0;
        int end = nums.length-1;
        while(start <end){
            int sum = nums[start] + nums[end];

            if(sum == target){
              System.out.println();
            } else if(sum < target){
                start++;
            } else{
                end--;

            }
           
        }
    }

}