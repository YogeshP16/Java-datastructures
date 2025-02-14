import java.util.Stack;

public class CollectionStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // Push elements
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Stack after pushes: " + s); // [10, 20, 30]

        // traverse
        for (Integer items : s) { 
            System.out.print(items + " "); // 10 20 30
            
        }

        // Peek → Get the top element
        System.out.println("Top Element: " + s.peek()); // 30

        // Pop → Remove top element
        System.out.println("Popped Element: " + s.pop()); // 30
        System.out.println("Stack after pop: " + s); // [10, 20]

        // Check if stack is empty
        System.out.println("Is stack empty? " + s.isEmpty()); // false

        
    }
}
