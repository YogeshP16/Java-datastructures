
import java.util.Arrays;

public class O6_SumofTwoMatix {

    public static void main(String[] args) {
        int[][] arr1 ={{1,2,3},{4,5,6}};
        int[][] arr2 = {{1,2,3}, {4,5,6}};


        int row =arr1.length;
        int col = arr2[0].length;
        

        // to store sum
        int[][] sum = new int[row][col]; 

 
        // to traverse and sum two matrices
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                sum[i][j] = arr1[i][j] + arr2[i][j]; 

            }
        }

        // to   print sum
        for (int[] i : sum) {
            System.out.println(Arrays.toString(i));
                
        }
           
            
        
    }

}
