

public class O13_ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] res = product(arr);
      
        for (int num : res) {
            System.out.print(num + " ");  // 24 12 8 6
        }
        
    }
    static int[] product(int[] arr){

        int n = arr.length;
        int[] result = new int[n];
        
        for(int i=0; i< n; i++){
            result[i] =1;
            for(int j=0; j<n; j++){
                if(i!= j){
                    result[i] *= arr[j];
                }
            }
        }
        return result;
    }

}