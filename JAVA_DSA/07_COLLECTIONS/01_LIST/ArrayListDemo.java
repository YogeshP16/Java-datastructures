import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {


        // Create a List of Integers
        List<Integer> l = new ArrayList<>();

        // adding (l.add()), access(l.get(index no)), update(l.set(index, element)), remove(l.remove(index))



        // Adding elements to the list
        l.add(11);
        l.add(23);
        l.add(35);
        l.add(55);
        l.add(77);

        // Adding elements at specific indices
        l.add(0, 456);   
        l.add(4, 789);  

        // Iterating through the list using a for-each loop
        System.out.print("List elements (for-each loop): ");
        for (Integer integer : l) {
            System.out.print(integer + " "); // Output: 456 11 23 35 789 55 77
        }
        System.out.println();



        // Accessing elements by index
        System.out.println("Element at index 5: " + l.get(5)); // Output: 55

        // Updating an element
        System.out.println("Updated element at index 3: " + l.set(3, 1000)); 
        // Updates 35 to 1000 and prints the old value (35)

        // Removing elements from the list
        System.out.println("Removed element at index 4: " + l.remove(4)); 
        // Removes the element at index 4 (789) and prints it



        // Iterating through the list using a for-loop
        System.out.print("List elements (for-loop): ");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " "); // Output: 456 11 23 1000 55 77
        }
        System.out.println();

        // Iterating through the list using a for-each loop
        System.out.print("List elements (for-each loop): ");
        for (Integer item : l) {
            System.out.print(item + " "); // Output: 456 11 23 1000 55 77
        }
        System.out.println();

        // Iterating through the list using an iterator
        // hasnext --> it check next element is present or not and return true (if present ) else false 
        // next --> it return next elements
        System.out.print("List elements (iterator): ");
        Iterator<Integer> i = l.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " "); // Output: 456 11 23 1000 55 77
        }
        System.out.println();


        // Searching for elements in the list
        // Check if an element exists
        boolean exist = l.contains(45); // Checks if 45 exists in the list
        System.out.println("Does 45 exist in the list? " + exist); // Output: false

        // Find the index of an element
        int index = l.indexOf(4); // Finds the index of element 4 (returns -1 if not found)
        System.out.println("Index of element 4: " + index); // Output: -1


       
        
    }
}


