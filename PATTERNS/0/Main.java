public class Main{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for(int i=0; i< arr.length; i++){
            if(arr[i] == 2 && arr[i+1] == 3){
                arr[i+1] = 0;
            }
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
        
    }
}