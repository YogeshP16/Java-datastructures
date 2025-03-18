import java.util.HashMap;
import java.util.Map;

/**
 * The O01_CountFrequency class provides methods to count the frequency of each element in an array.
 * It includes both a brute force approach and an optimized approach to solve the problem.
 * </pre>
 * 
 * <p>Methods:
 * <ul>
 * <li>{@link #countNumbers(int[])} - Brute force approach to count frequency of elements.
 * <li>{@link #countFreq(int[])} - Optimized approach to count frequency of elements.
 * <li>{@link #printFrequency(Map)} - Prints the frequency of elements.
 * </ul>
 */
public class O01_CountFrequency {
    public static void main(String[] args) {
        int[] arr = {1,1,1,22,2,2,2,4,4,5,6,6,6,6,7};
        
        // Brute force approach
        Map<Integer, Integer> result = countNumbers(arr);
        printFrequency(result);

        System.out.println();

        // Optimized approach
        Map<Integer, Integer> result1 = countFreq(arr);
        printFrequency(result1);

        // most frequent elements
        int[] arr2 = {1,1,1,22,2,2,2,4,4,5,6,6,6,6,7};
        Integer result2 = countMostFrequent(arr2);
        System.out.println("Most frequent element: " + result2);

    }

    // Brute force --> tc- O(n^2) sc- O(n)
    static HashMap<Integer, Integer> countNumbers(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            map.put(arr[i], count);
        }
        return map;
    }

    // Optimized tc - O(n), sc- O(n)
    static Map<Integer, Integer> countFreq(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();
        for(Integer i : arr){
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        return count;
    }

    // find most frequent number
    static int countMostFrequent(int[] arr2){
        int maxFreq = 0;
        int maxElement = -1;

        Map <Integer, Integer> count = new HashMap<>();
        for(Integer i : arr2){
            count.put(i, count.getOrDefault(i, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                maxElement = entry.getKey();
            }
        }
        return maxElement;
    }

    // Print frequency of elements
    static void printFrequency(Map<Integer, Integer> frequencyMap) {
        frequencyMap.forEach((key, value) -> System.out.print(key + ":" + value + " "));
    }
}
