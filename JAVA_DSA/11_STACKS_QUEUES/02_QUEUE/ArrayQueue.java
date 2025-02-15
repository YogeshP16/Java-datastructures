public class ArrayQueue {
    static final int MAXSIZE = 10;
    int[] arr;
    int front, rear;

    ArrayQueue(){
        arr = new int[MAXSIZE];
        front = -1;
        rear = -1;
    }

    public void enqueue(int data){
        if(rear == MAXSIZE-1) throw new IndexOutOfBoundsException("queue is full");
        if(front == -1) front++;
        arr[++rear] = data;


    }

    public int dequeue(){
        if(front == -1 || front > rear) throw new IndexOutOfBoundsException("queue is not full"); // check front is empty
        return  arr[front++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);   // add elements O(1) tc & O(N) sc
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.dequeue());   // delete the front elements O(1) tc & O(N) sc
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        


        
    }


}
