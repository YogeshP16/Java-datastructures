

public class O1_SumofElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        // sum
        int res = sum(arr);
        System.out.println(res);  // 15

        double res1 = average(arr, res);
        System.out.println(res1);        // 3.0

        int[] res2 = cummulativeSum(arr);
        for(int i : res2)
            System.out.print(i + " ");    // 1 3 6 10 15


    }

    static int sum(int[] arr){     // -----> return type is int
        int sum =0;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];  
        }
        return sum;

    }

    static double average(int[] arr, int sum){  // return type is double
        double avg = (double)sum/arr.length;
        return avg;

    }

    static int[] cummulativeSum(int[] arr){   // ----> here return type will be array of integer
        int[] result = new int[arr.length];

        result[0] = arr[0];  // set first element of the result array --> [1,0,0,0]

        for(int i=1; i< arr.length;  i++){     // iterate 1 to n and add to result array
            result[i] = result[i-1] +arr[i];
        }
        return result;
    }
}
    

