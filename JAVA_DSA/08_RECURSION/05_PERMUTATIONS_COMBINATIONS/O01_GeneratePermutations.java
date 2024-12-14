import java.util.ArrayList;
import java.util.List;

public class O01_GeneratePermutations {

    public static void main(String[] args) {

        int[] arr = {1,2,3};
        List<List<Integer>> res = permutations(arr);
        for(List<Integer> i : res){
            System.out.println(i);
        }

        String s = "ABC";
        List<String> res1 = permutationss(s);
        for(String i : res1){
            System.out.println(i);
        }
        
    }
    static List<List<Integer>> permutations(int[] arr){
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i< arr.length; i++){
            for(int j=0; j< arr.length; j++){
                if(i==j) continue;
                for(int k =0; k<arr.length; k++){
                    if( k==i  || k==j) continue;

                    List<Integer> permutation = new ArrayList<>();
                    permutation.add(arr[i]);
                    permutation.add(arr[j]);
                    permutation.add(arr[k]);
                    list.add(permutation);
                    
                }
            }
        }
        return list;
    }
    /*
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
 */

    static List<String> permutationss(String s){
        List<String> result = new ArrayList<>();
        char [] chars = s.toCharArray();
        int n = chars.length;


        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if(i==j) continue;
                for(int k =0; k< n; k++){
                    if( k==i  || k==j) continue;

                    StringBuilder permutation = new StringBuilder();
                    permutation.append(chars[i]);
                    permutation.append(chars[j]);
                    permutation.append(chars[k]);
                    result.add(permutation.toString());
                    
                }
            }
        }
        return result;
    }
}

/*
ABC
ACB
BAC
BCA
CAB
CBA


Outer Loop Breakdown (i = 0, 1, 2):

1. When i = 0 (First character = 'A'):
j = 1 (Second character = 'B'):

k = 2 (Third character = 'C'): ABC (Result: ["ABC"])
j = 2 (Second character = 'C'):

k = 1 (Third character = 'B'): ACB (Result: ["ABC", "ACB"])
2. When i = 1 (First character = 'B'):
j = 0 (Second character = 'A'):

k = 2 (Third character = 'C'): BAC (Result: ["ABC", "ACB", "BAC"])
j = 2 (Second character = 'C'):

k = 0 (Third character = 'A'): BCA (Result: ["ABC", "ACB", "BAC", "BCA"])
3. When i = 2 (First character = 'C'):
j = 0 (Second character = 'A'):

k = 1 (Third character = 'B'): CAB (Result: ["ABC", "ACB", "BAC", "BCA", "CAB"])
j = 1 (Second character = 'B'):

k = 0 (Third character = 'A'): CBA (Result: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"])

 */


