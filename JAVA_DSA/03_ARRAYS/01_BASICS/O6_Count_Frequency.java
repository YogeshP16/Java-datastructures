

public class O6_Count_Frequency {
    public static void main(String[] args) {

        int[] arr ={1,2,3,3,4,5,6,7,7,7,7,8};
        boolean[] vist = new boolean[arr.length];

        for(int i=0; i<arr.length; i++){
            if(vist[i]) continue;

            int count =1;
            for(int j = i+1; j<arr.length; j++){

                if (arr[i] == arr[j]){
                    vist[j] =  true;
                    count++;
                }
            }
            System.out.println(" " + arr[i] + " | " + count);
        } 


        


    }

}
