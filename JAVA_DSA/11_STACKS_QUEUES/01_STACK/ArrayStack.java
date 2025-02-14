public class ArrayStack {
    static final int MAXSIZE = 10;
    int[] arr = new int[MAXSIZE];
    int top;

    ArrayStack() {
        top = -1;
    }

    // Push → Add the value to stack
    void push(int data) {
        if (top == MAXSIZE - 1) throw new IndexOutOfBoundsException("Stack is full");
        arr[++top] = data; // Increment top and insert
    }

    // Pop → Remove the top value
    int pop() {
        if (top == -1) throw new IndexOutOfBoundsException("Stack is empty");
        return arr[top--];
    }

    // Peek → View top element
    int peek() {
        if (top == -1) throw new IndexOutOfBoundsException("Stack is empty");
        return arr[top];
    }

    // isEmpty → Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Print Stack
    void printStack() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        
        System.out.println("Top Element: " + s.peek()); // Should print 60
        
        s.pop(); // Removes 60
        s.printStack(); // Prints remaining stack ->  Stack: 10 20 30 40 50 
    }
}
