package likedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyLinkedList {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        // First pass: create new nodes with only next pointers and store them in a map
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        // Second pass: set the random pointers of the new nodes based on the map
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        // Create the original linked list
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Set random pointers
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        // Print the original linked list
        System.out.println("Original Linked List:");
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + ", ");
            if (curr.random == null) {
                System.out.print("null");
            } else {
                System.out.print(curr.random.val);
            }
            System.out.print("] -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // Create a deep copy of the linked list
        Node copyHead = copyRandomList(head);

        // Print the deep copy
        System.out.println("Deep Copy Linked List:");
        curr = copyHead;
        while (curr != null) {
            System.out.print("[" + curr.val + ", ");
            if (curr.random == null) {
                System.out.print("null");
            } else {
                System.out.print(curr.random.val);
            }
            System.out.print("] -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}