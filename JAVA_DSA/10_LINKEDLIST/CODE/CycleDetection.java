public class CycleDetection {
    public static void main(String[] args) {
        
    }

    // find cycle detection

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }

        }
        return false;
        
    }

    // find the length of the cycle detection

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

                // calculate the length
                ListNode temp = slow;
                int length =0;
                do {
                    temp = temp.next;
                    length++;
                }while(temp != slow);

                return length;
                
            }

        }
        return false;
        
    }

    // cycle detection II  --> If there is a cycle in the list, return the node where the cycle starts.
    //                         If there is no cycle, return null.

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
    
        ListNode slow = head, fast = head;
        
        // Step 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // Cycle detected
        }
    
        // No cycle found
        if (fast == null || fast.next == null) return null;
        
        // Step 2: Find cycle start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
    
        return slow; // Start of the cycle
    }
     

}
