import java.util.Stack;

public class QueueUsingStack {
    /*
      Approach:
        We use two stacks:
        inStack → Used for enqueue (push) operations.
        outStack → Used for dequeue (pop) operations.
        In push:
            s1 -> s2
            adding new element -> s1
            s2  -> s1

        When popping an element:
        If outStack is empty, transfer all elements from inStack to outStack.
        Pop the top of outStack.
     */

     Stack<Integer> inStack;
     Stack<Integer> outStack;

     // constructor
     public QueueUsingStack(){
        inStack = new Stack<>();
        outStack = new Stack<>();
     }

     // enqueu operatiom -> add
     public void push(int data){
        inStack.push(data);
     }

     // Dequeue operation
     public int pop(){
        if(inStack.isEmpty() && outStack.isEmpty()) throw new IndexOutOfBoundsException("Empty");

        shiftStacks();
        return outStack.pop();
     }

     public int peek(){
        if(inStack.isEmpty() && outStack.isEmpty()) throw new IndexOutOfBoundsException("Empty");

        shiftStacks();
        return outStack.peek();

     }

     private void shiftStacks(){
        if(outStack.isEmpty()){
            while (! inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
     }


     

     public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);
        
        System.out.println(q.pop());  // Output: 10
        System.out.println(q.peek()); // Output: 20
        System.out.println(q.pop());  // Output: 20
        
     }

}
