public class O01_Sum {
    public static void main(String[] args) {
        int [] arr = {12,23,34,45,56};
        System.out.println(sumarr(arr));

        cummulativesum(arr);
        for(int i: arr){
            System.out.print(i + " ");
        }
    }

    static int sumarr(int arr []){  // 170
        int sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
        }
    return sum;
    } 

    static int cummulativesum(int arr []){   // 12 35 69 114 170
        for(int i =1; i< arr.length; i++){
            arr[i] += arr[i-1];
        }
                return 0;
        

    }

}
