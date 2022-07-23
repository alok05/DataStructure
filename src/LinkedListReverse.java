// Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        
        return head;
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