public class OO3_Rotated_Binary_Search {
    public static void main(String[] args) {

        int [] arr = {5,6,7,8,9,1,2,3,4};
        System.out.println(binary(arr, 5, 0, arr.length-1));
        
    }
    static int binary(int[] arr, int target, int s, int e){
        if(s > e) return -1;            // 

        int m = s +(e - s)/2;           // find mid value
        if(arr[m] == target){           //  if target == mid -->  return mid
            return m;
        }

        // check first half -->  if target present or not -->from start to mid

        if(arr[s] <= arr[m]){
            // check target present inbetween start to mid is sorted
            if (target >= arr[s] && target <= arr[m]){
                return binary(arr, target, s, e = m-1);  // if present --> e = mid - 1
            }else {
                return binary(arr, target, s = m+1, e);  // if not present --> s = mid + 1
            }
        }

        // check second half --> from mid to end
        if (target >= arr[m]  && target <= arr[e]){
            return binary(arr, target, s = m+1, e);    // if present --> s = mid +1
        }

        return binary(arr, target, s, e = m-1);   // if not present --> e = mid -1


    }

}
