class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node(" + data + ")";
    }
}

class LL{
    Node head;
    Node tail;
    int size;

    //Insert at first
    /*
     * create new node
     * point new node next to current head
     * update head to new node
     * if list is empty point tail to new head
     * then increase the  size to add next node
     */
    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;

        }
        size++;
    }

    // To Display
    /*
     * create temp variable to store head
     * while temp not null --> print & move to next 
     */
    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("Null you reached to end");
    }

    // Insert at End
    /*
     * create new node
     * check if tail is empty or not -> (if empty --> then call insertFirst() Method)
     * else
     * set tail.next to new node
     * update tail to new node then increment
     */
    public void inserEnd(int data){
        Node node = new Node(data);
        if(tail == null){
            insertFirst(data);
            return;
        }
        
        tail.next = node;
        tail = node;
        size++;

    }

    // Insert value at random index
    /*
     * if index 0 -> insertFirst()
     * if index size ->  insertLast()
     * create new node
     * travers node just before insertion
     * insert node at specific index
     */
    public void insertAt(int data, int index){
        if(index == 0){
            insertFirst(data);
            return;
        } 

        if(index == size){
            inserEnd(data);
            return;
        }

        Node node = new Node(data); // if we want insert 50
        Node temp = head;
        for(int i =1; i< index; i++){  // it traverse to index point
            temp = temp.next;
        }
                                // before insertion 20 -> 30 -> 40 
        node.next = temp.next;  // after insertion --> 50.next -> 30 
        temp.next = node;  // after insertion --> 20.next  -> 50  --> final res -> 20-> 50 -> 30 -> 40
        size++;

    }

    // Delete First
    /*
     * change head to head.next
     * check head, tail == null or not (this is edge case when we have only one element in list)
     */
    public int deleteFirst(){
        int data = head.data;
        head = head.next;

        if(head == null){
            tail = null;
        }
        size--;
        return data;
    }

    // how to get index to delete element
     public Node get(int index){
        Node node = head;
        for(int i=0; i< index; i++){
            node = node.next;
        }
        return node;
     }

    // Delete Last --> O(N)
    /*
     * if size <= 1 --> call deleteFirst()
     * traverse to secondLast node using get(size-2) --> get() is above deleteLast
     * store the delete data
     * update tail to secondLast
     * set tail.next = null
    */
     public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }

        Node secondLast = get(size-2);
        int data = tail.data; // store the delete data
        tail=secondLast;
        tail.next = null;
        return data;  // return the deleted data
     }

     // Delete Random via Index -> O(N)
     /*
      * find the previous index using get()
      * store the deleted value
      * skip over the node to delete
      * return the deleted value
      */
     public int deleteRandom(int index){
        if(index == 0){
            return deleteFirst();

        }

        if(index == size-1){
            return deleteLast();
        }

        Node previous = get(index-1);
        int data = previous.next.data; // store  data
        previous.next = previous.next.next; // skip over the node to delete
        return data;

     }

     // How to find Value
     public Node find(int data){
        Node temp = head;
        while (temp != null){
            if(temp.data == data){
                return temp;
            }
            temp = temp.next;
        } 
        return null;
     }



}


public class SinglyLLDemo {
    public static void main(String[] args) {
        LL  l = new LL();
        l.insertFirst(20);
        l.insertFirst(30);
        l.insertFirst(40);
        l.insertFirst(60);
        l.insertFirst(80);
        l.insertFirst(100);
        l.print();  // 100-->80-->60-->40-->30-->20-->Null you reached to end

        l.inserEnd(10);
        l.inserEnd(5);
        l.print(); // 100-->80-->60-->40-->30-->20-->10-->5-->Null you reached to end

        l.insertAt(50, 4);
        l.print(); // 100-->80-->60-->40-->50-->30-->20-->10-->5-->Null you reached to end

        System.out.println(l.deleteFirst()); // 100
        l.print();  // 80-->60-->40-->50-->30-->20-->10-->5-->Null you reached to end

        System.out.println(l.deleteLast()); // 5
        l.print();  // 80-->60-->40-->50-->30-->20-->10-->Null you reached to end

        System.out.println(l.deleteRandom(2));  // 40
        l.print();  // 80-->60-->50-->30-->20-->10-->Null you reached to end

        System.out.println(l.find(50)); // Node(50)




   
        
        
        
    }

}
