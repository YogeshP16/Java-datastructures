
public class O4_LinearSearch {
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {1,2,3,45,6,7,8};
        boolean found = false;
        for(int num : arr){
            if(num == target){
                found = true;
                break;
            }
        }
        System.out.println(found ? "element found": "not found");
    }

}
