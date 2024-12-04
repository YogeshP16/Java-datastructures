public class OO1_Check_Array_Sorted {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(sorted(arr, 0));

        
    }
    static boolean sorted(int[] arr, int index){
        // base
        if(index == arr.length-1) return true;
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    
    }
}
