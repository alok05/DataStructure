package likedlist;// Java program to remove duplicates
// from unsorted linkedlist

import java.util.HashSet;

public class LinkedListRemoveDuplicateFromUnsorted {
    static class node {

        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }
    /* Function to remove duplicates from a unsorted linked list
    * We traverse the link list from head to end. For every newly encountered element,
    * we check whether it is in the hash table: if yes, we remove it; otherwise we put it in the hash
    * table.
    * Thanks to bearwang for suggesting this method.
      Time Complexity: O(N) on average
      (assuming that hash table access time is O(1) on average).
      Auxiliary Space : O(N)
      As extra space is used to store the elements in the stack.
    *  */
    static void removeDuplicate(node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();
        /* Pick elements one by one */
        node current = head;
        node prev = null;
        while (current != null) {
            int curval = current.val;
            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }
    /* Function to print nodes in a given linked list */
    static void printList(node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void removeDuplicates(Node head){
        Node current = head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<>();
        while(current != null){
            if(set.contains(current.val)){
                prev.next = current.next;
            } else {
                set.add(current.val);
                prev = current;
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
		    /* The constructed linked list is:
		    10->12->11->11->12->11->10*/
        node start = new node(10);
        start.next = new node(12);
        start.next.next = new node(11);
        start.next.next.next = new node(11);
        start.next.next.next.next = new node(12);
        start.next.next.next.next.next = new node(11);
        start.next.next.next.next.next.next = new node(10);

        System.out.println(
            "Linked list before removing duplicates :");
        printList(start);

        removeDuplicate(start);

        System.out.println(
            "\nLinked list after removing duplicates :");
        printList(start);
    }
}
