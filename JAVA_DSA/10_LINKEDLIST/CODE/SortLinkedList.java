// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortLinkedList {
    public static void main(String[] args) {
        // Example test case: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        SortLinkedList sorter = new SortLinkedList();
        ListNode sorted = sorter.sortList(head);
        printList(sorted);
    }

    // Sorts the linked list using Merge Sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: already sorted
        }

        // Find middle and split list
        ListNode mid = middleNode(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // Split the list

        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // Merge the two sorted halves
        return mergeSorted(left, right);
    }

    // Merges two sorted linked lists
    ListNode mergeSorted(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // Dummy node
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { // Fix: changed `data` to `val`
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next; // Return merged sorted list
    }

    // Finds the middle node using slow/fast pointer method
    ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow; // Track node before middle
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null; // Split the list
        return slow; // `slow` is the middle node
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
