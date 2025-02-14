/*

Problem with Custom ArrayList
Without generics, you can't store multiple types, and you'll need to create separate implementations for each type.

public class Main {
    public static void main(String[] args) {

        /* 
        CustomArrayList list = new CustomArrayList();
        list.add("Hello");
        list.add(2);
        System.out.println(list.get(0)); // Output: Hello
        System.out.println(list.size()); // Output: 2
        
    }
}
*/ 

// Generics enable type safety:

public class Main {
    public static void main(String[] args) {

        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("hey");
        list.add("how");
        list.add("r u");
       // list.add(12); --------> it throw compile time error

        System.out.println(list.get(0)); // Output: Hello
        System.out.println(list.size()); // Output: 2


        // Using Wildcard Method to Print Lists
        System.out.println("String List:");
        CustomArrayList.printList(list);
    }
}
/*
Hello
5
String List:
Hello
World
hey
how
r u
 */