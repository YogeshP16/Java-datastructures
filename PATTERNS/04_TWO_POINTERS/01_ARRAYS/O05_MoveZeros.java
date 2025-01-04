public class O05_MoveZeros {
    public static void main(String[] args) {
        int [] arr = {1,2,0,3,0,4,0,5,0};
        moveZeros(arr);
        for(int i : arr){
            System.out.print(i + " ");    // 1 2 3 4 5 0 0 0 0
        }

        System.out.println();

        moveZerostofirst(arr);
        for(int j : arr){
            System.out.print(j + " ");    // 0 0 0 0 5 1 2 3 4
        }
    }
    
    static void moveZeros(int[] arr){
        int nonzeroindex = 0;

        for(int curr =0; curr < arr.length; curr++){
            if(arr[curr] != 0){

                int temp = arr[nonzeroindex];
                arr[nonzeroindex] = arr[curr];
                arr[curr] = temp;

                nonzeroindex++;
            }
        }
    }

    static void moveZerostofirst(int[] arr){
        int nonzeroindex = 0;

        for(int curr = 0; curr < arr.length; curr++){
            if(arr[curr] == 0){

                int temp = arr[nonzeroindex];
                arr[nonzeroindex] = arr[curr];
                arr[curr] = temp;

                nonzeroindex++;
            }
        }
    }




}
