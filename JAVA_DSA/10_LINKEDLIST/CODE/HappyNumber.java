/*
Step 1: 1² + 9² = 1 + 81 = 82  
Step 2: 8² + 2² = 64 + 4 = 68  
Step 3: 6² + 8² = 36 + 64 = 100  
Step 4: 1² + 0² + 0² = 1 → Happy Number --->  if not 1 then it is not Happy Number

 */


public class HappyNumber {
    public static void main(String[] args) {
        
    }
    public boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(seen.contains(n)){
                return false;
            }
            seen.add(n);
            n = findSquare(n);
        }
        return true;
        



    }
    private int findSquare(int num){
        int ans =0;
        while(num > 0){
            int rem = num % 10;
            ans += rem * rem;
            num /=10;
        }
        return ans;
    }

}
