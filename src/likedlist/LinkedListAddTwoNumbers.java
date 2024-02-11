package likedlist;
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored
// in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


// Definition for singly-linked list
public class LinkedListAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode head = new ListNode(0);
        ListNode currentHead = head;

        int sum = 0;

        while (current1 != null || current2 != null) {
            sum /= 10;

            if (current1 != null) {
                sum += current1.val;
                current1 = current1.next;
            }

            if (current2 != null) {
                sum += current2.val;
                current2 = current2.next;
            }

            currentHead.next = new ListNode(sum % 10);
            currentHead = currentHead.next;
        }

        if (sum / 10 == 1) {
            currentHead.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        LinkedListAddTwoNumbers linkedListAddTwoNumbers = new LinkedListAddTwoNumbers();

        ListNode listNode = linkedListAddTwoNumbers.addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
