public class ReverseLinkedList {
    public static void main(String[] args) {
        
    }

    // reverrs ll
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // reverse ll in subpart

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next; // Move `prev` to the node before `left`
        }

        // Start reversing
        ListNode subListHead = prev.next;
        ListNode curr = subListHead;
        ListNode prevNode = null;

        for (int i = 0; i <= right - left; i++) {  // ✅ Fixed loop condition
            ListNode next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }

        // Connect reversed sublist back
        prev.next = prevNode;
        subListHead.next = curr;

        return dummy.next;
    }

}
