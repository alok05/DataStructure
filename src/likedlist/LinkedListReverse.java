package likedlist;// Reverse a singly linked list.

/**
 * Definition for singly-linked list. public class likedlist.ListNode { int val; likedlist.ListNode next; likedlist.ListNode(int
 * x) { val = x; } }
 */
public class LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            // Store next
            next = current.next;
            // Reverse current node's next pointer
            current.next = previous;
            // Move pointers one position ahead
            previous = current;
            current = next;
        }
        // Return the head of reversed linked list
        return previous;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(5);

        LinkedListReverse linkedListReverse = new LinkedListReverse();
        ListNode reverseListNode = linkedListReverse.reverseList(listNode);
        while (reverseListNode != null) {
            System.out.println(reverseListNode.val);
            reverseListNode = reverseListNode.next;
        }
    }
}
