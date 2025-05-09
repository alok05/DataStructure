package likedlist;// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class likedlist.ListNode { int val; likedlist.ListNode next; likedlist.ListNode(int
 * x) { val = x; } }
 */
public class LinkedListMergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val < o2.val) {
                        return -1;
                    } else if (o1.val == o2.val) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

    public ListNode merge(ListNode node1, ListNode node2){
        // Base cases
        if(node1 == null){
            return node2;
        }
        if(node2 == null){
            return node1;
        }
        // Recursive merging based on smaller value
        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        } else{
            node2.next = merge(node1, node2.next);
            return node2;
        }

    }

    public boolean detectLoop(ListNode node){
        ListNode slow = node, fast = node;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
