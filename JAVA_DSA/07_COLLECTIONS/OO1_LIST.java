/*
What is a List?
A List is an ordered collection in Java that:

Maintains insertion order.
Allows duplicate elements.
Provides indexed access to elements.


Implementations of the List Interface
----------------------------------------
ArrayList
-------------
Backed by a dynamic array.
Fast for random access (get() and set() are O(1)).
Slower for insertions/deletions in the middle (shifting required).

LinkedList
---------------
Backed by a doubly-linked list.
Fast for insertions/deletions anywhere (add() and remove() are O(1) for iterators).
Slower for random access (get() is O(n)).

Vector
---------
Synchronized version of ArrayList (not commonly used now).
Thread-safe but slower due to synchronization overhead.


Key Methods in the List Interface
----------------------------------
Method	                        Description	                                           Example
add(E e)	                    Appends an element to the list.	                       list.add("apple");
add(int index, E element)	    Inserts an element at a specific index.	               list.add(1, "banana");
get(int index)	                Retrieves the element at a specific index.	           String fruit = list.get(0);
set(int index, E element)	    Replaces the element at a specific index.	           list.set(0, "grape");
remove(int index)	            Removes the element at a specific index.	           list.remove(0);
remove(Object o)	            Removes the first occurrence of the specified element. list.remove("apple");
size()	                        Returns the number of elements in the list.	           int size = list.size();
contains(Object o)	            Checks if the list contains a specific element.	       boolean hasApple = list.contains("apple");
indexOf(Object o)	            Returns the index of the first occurrence.	           int index = list.indexOf("banana");
lastIndexOf(Object o)	        Returns the index of the last occurrence.	           int lastIndex = list.lastIndexOf("banana");
clear()	                        Removes all elements from the list.	                   list.clear();
isEmpty()	                    Checks if the list is empty.	                       boolean empty = list.isEmpty();
subList(int fromIndex, int toIndex)	Returns a view of a portion of the list.	       List<String> sub = list.subList(1, 3);Differences Between ArrayList and LinkedList


Feature	                      ArrayList	                        LinkedList
Storage	                      Dynamic array.	                Doubly-linked list.
Access Speed	              Fast (O(1)).	                    Slower (O(n)).
Insertion/Deletion	          Slower in the middle (O(n)).	    Fast in the middle (O(1) if iterator is used).
Memory Usage	              Less (array overhead only).	    More (node objects required).


Thread-Safe Alternatives
-------------------------
CopyOnWriteArrayList (from java.util.concurrent):
Thread-safe alternative to ArrayList.
Performs a copy of the underlying array on each modification, making it slower for writes but fast for reads.

Collections.synchronizedList(List):
Wraps any list in a synchronized wrapper.

 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OO1_LIST {
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
