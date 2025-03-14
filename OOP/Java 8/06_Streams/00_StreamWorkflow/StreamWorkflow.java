import java.util.List;
import java.util.stream.Collectors;

/*
How It Works Internally?
Streams use a pull-based model (or lazy evaluation), meaning:

A terminal operation is called (e.g., collect()).
The stream doesn't process all elements at once. Instead, it follows a demand-driven (pull) approach.

For each element:
It passes through all intermediate operations (map(), filter(), etc.) before moving to the next element.
This is called vertical execution (element-by-element processing) instead of horizontal execution (stage-by-stage processing).

## Lazy evaluation: Intermediate operations run only when a terminal operation is called
Before calling collect(), nothing runs. The stream is just prepared.
✔ After calling collect(), filtering & mapping happen together, element by element.
✔ Intermediate operations (filter, map) execute only when needed.
 */


public class StreamWorkflow {
    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Process the list using streams
        List<Integer> result = numbers.stream()
            // Filter out odd numbers
            .filter(n -> {
                System.out.println("Filtering " + n);
                return n % 2 == 0;
            })
            // Map each remaining number to its double
            .map(n -> {
                System.out.println("Mapping " + n);
                return n * 2;
            })
            // Collect the results into a list
            .collect(Collectors.toList());

        // Print the resulting list
        System.out.println(result);

    }
}

/*
Expected output:
Filtering 1
Filtering 2
Mapping 2
Filtering 3
Filtering 4
Mapping 4
Filtering 5
[4, 8]
 */