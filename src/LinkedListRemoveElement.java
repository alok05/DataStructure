public class LinkedListRemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        LinkedListRemoveElement solution = new LinkedListRemoveElement();
        ListNode newHead = solution.removeElements(head, 6);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

        // Example 2
        ListNode head2 = null;
        ListNode result2 = solution.removeElements(head2, 1);
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
        // Example 3
        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(7);
        head3.next.next.next = new ListNode(7);
        ListNode result3 = solution.removeElements(head3, 7);
        while (result3 != null) {
            System.out.print(result3.val + " ");
            result3 = result3.next;
        }
    }
}
