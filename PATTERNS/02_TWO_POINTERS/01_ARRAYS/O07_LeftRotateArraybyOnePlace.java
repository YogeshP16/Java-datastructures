/* 
Store the first toy(arr[0]) in a safe place (temp).
Move all the toys(arr) one step left (from left to right, keeping the order).
Place the first toy(arr[0]) at the last spot(right).
 */



public class O07_LeftRotateArraybyOnePlace {
    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5};
        rotateArray(arr);
        for(int i : arr){
            System.out.print(i + " " );  // 2 3 4 5 1 
        }
  
    }
    static void rotateArray(int[] arr){
        int left =0;
        int right = arr.length-1;

        // Store the first toy(arr[0]) in a safe place (temp)
        int temp = arr[0];

        // Move all the toys one step left
        while(left < right){
            arr[left] = arr[left+1];
            left++;
        }
        // Place the first toy at the last spot.
        arr[right] =temp;
    }

}












