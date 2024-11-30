/*
 What is a Set?
A Set is a collection in Java that:

Does not allow duplicate elements.
Does not guarantee insertion order (except in specific implementations).
Provides operations for mathematical set theory (union, intersection, etc.).

Implementations of the Set Interface
--------------------------------------
HashSet
--------
Backed by a HashMap.
Fast for add, remove, and contains operations (O(1) average).
Does not preserve insertion order.

LinkedHashSet
------------
Extends HashSet.
Preserves insertion order.
Slightly slower than HashSet due to the additional ordering overhead.

TreeSet
----------
Backed by a TreeMap.
Stores elements in sorted (ascending) order.
Slower than HashSet for most operations (O(log n) due to tree structure).

EnumSet
-------
Specialized for enums.
Very efficient for fixed set of constants.


Key Methods in the Set Interface
--------------------------------
Method	            Description                  	            Example

add(E e)	        Adds an element to the set.	                set.add("apple");
remove(Object o)	Removes the specified element.	            set.remove("apple");
contains(Object o)	Checks if the set contains the specified element.	boolean exists = set.contains("apple");
size()	            Returns the number of elements in the set.	int size = set.size();
isEmpty()	        Checks if the set is empty.	                boolean empty = set.isEmpty();
clear()	            Removes all elements from the set.	        set.clear();
iterator()	        Returns an iterator for the set.	        Iterator<String> itr = set.iterator();

Thread-Safe Alternatives
-------------------------
Collections.synchronizedSet(Set):
Wraps a set in a synchronized wrapper.


Special Features of Set
------------------------
No Duplicates:
If an element already exists, add(E e) does not add it again and returns false.

Mathematical Set Operations:
Union: Combine two sets.
Intersection: Common elements between two sets.
 */


import java.util.HashSet;

public class OO2_SET {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        // add
        set.add(12);
        set.add(34);
        set.add(35);
        set.add(34);
        set.add(36); 
        set.add(37);
        set.add(39);
        set.add(44); 

        set1.add(56);
        set1.add(34);
        set1.add(67);
        set1.add(44);

                                //  it print 34 one time only cuz it doesnt allow duplicates
        System.out.println(set);  // [34, 35, 36, 37, 39, 12, 44] 

        // remove element directly
        set.remove(44);
        System.out.println(set); // [34, 35, 36, 37, 39, 12] --> unordered
        
        // contains
        System.out.println(set.contains(34)); // true
        
        // size
        System.out.println(set.size());  // 6

        //is empty
        System.out.println(set.isEmpty());  // false


        // UNION ---> USE addall() 
        HashSet <Integer> union = new HashSet<>(set);
        union.addAll(set1);
        System.out.println(union);     // [34, 35, 67, 36, 37, 39, 56, 12, 44]

        // INTERSECTION --> USE --> retainAll()

        HashSet <Integer> intersection = new HashSet<>(set);
        intersection.retainAll(set1);
        System.out.println(intersection);  // [34]



    }

}
