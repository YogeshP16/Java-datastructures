public class O08_RotateArraybyKPlace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k =2;
        rotate(arr, k);
        for(int i: arr){
            System.out.print(i + " ");    // 3 4 5 1 2
        }
    }

    static void rotate(int[] arr, int k){
        int n = arr.length;
        k = k%n;  // In case k is larger than the array size

        if(k==0) return;

        reverse(arr, 0, k-1);   // Reverse the first k elements
        reverse(arr, k, n-1);        // Reverse the remaining elements
        reverse(arr, 0, n-1);   // Reverse the entire array

    }
    static void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

}
