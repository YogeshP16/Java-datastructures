import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        // add elements 
        l.add(10);
        l.add(20);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(100);
        l.add(110);

        // add first and last
        l.addFirst(5);
        l.addLast(120);

        // Access 
        System.out.println(l.get(3));  // 40
        System.out.println(l.getFirst());    // 5
        System.out.println(l.getLast());     // 120

        //access all
        System.out.println(l);  // [5, 10, 20, 40, 50, 60, 100, 110, 120]

        // remove
        l.remove(3);
        l.removeFirst();
        l.removeLast();

        System.out.println(l);  // [10, 20, 50, 60, 100, 110]

        System.out.println(l.size());  // 6    
        
    }

}

