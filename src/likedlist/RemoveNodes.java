package likedlist;

public class RemoveNodes {

    public static ListNode removeNodesGreaterThanThreshold(ListNode head, int threshold) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val > threshold) {
                // Remove the node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example linked list: 1 -> 5 -> 2 -> 8 -> 3 -> 7
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(7);

        int threshold = 5;
        System.out.println("Original Linked List:");
        printLinkedList(head);

        head = removeNodesGreaterThanThreshold(head, threshold);

        System.out.println("\nLinked List after removing nodes greater than " + threshold + ":");
        printLinkedList(head);
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
