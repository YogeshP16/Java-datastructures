public class O03_ReverseArray {

    public static void main(String[] args) {
        O03_ReverseArray res = new O03_ReverseArray();
        int[] a ={1,2,3,4};
        res.reverse(a);
                for(int i : a){
                    System.out.print(i + " ");
                }
            }
        public void reverse(int[] a){
        int left =0;
        int right = a.length-1;

        while(left < right){
            int temp = a[left];
            a[left]  = a[right];
            a[right] = temp;

            left++;
            right--;
        }
        

    }
}
