
public class O5_FindLargest {
    public static void main(String[] args) {
        int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};

        // find largest in entire matrix
        int largest1 = arr[0][0];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] > largest1){
                    largest1 = arr[i][j];
                }
            }
        }
        System.out.println("largest in entire matrix: "+largest1);  // 9

        System.out.println();

        //largest element in each row

        for(int i=0; i<arr.length; i++){
            int largest = arr [i][0];
            for(int j=1; j<arr[i].length; j++){
                if(arr[i][j] > largest){
                    largest = arr[i][j];
                }

            }
        
            System.out.println("Largest element in each row " + (i+1) + ": " + largest);
        }

    }

}

/*
 * largest in entire matrix: 9

Largest element in each row 1: 3
Largest element in each row 2: 6
Largest element in each row 3: 9
 */