public class O06_RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,4,5,6,6,6,7};
        int res = removeDuplicates(arr);

        for(int k=0; k < res; k++){
            System.out.print(arr[k] + " ");  // 1 2 3 4 5 6 7 
        }
    }
    // two pointer with fast slow pointer approach
    static int removeDuplicates(int[] arr){
        if(arr.length == 0) return 0;

        int i =0; // slow pointer

        for(int j =1; j<arr.length; j++){  // j --> fast pointer
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

}
