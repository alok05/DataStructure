package likedlist;

// Java Program for the above approach
class LinkedListMiddle {
    /*Creating a new Node*/
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    /*Function to add a new Node*/
    public void pushNode(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }
    /*Displaying the elements in the list*/
    public void printNode() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Null" + "\n");
    }
    /*Finding the length of the list.*/
    public int getLen() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    /*Printing the middle element of the list.*/
    public void printMiddle() {
        if (head != null) {
            int length = getLen();
            Node temp = head;
            int middleLength = length / 2;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is ["
                + temp.data + "]");
            System.out.println();
        }
    }

    // Function to get the middle of the linked list
    public int getMiddle() {

        // Initialize the slow and fast pointer to the head
        // of the linked list
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {

            // Move the fast pointer by two nodes
            fast_ptr = fast_ptr.next.next;

            // Move the slow pointer by one node
            slow_ptr = slow_ptr.next;
        }

        // Return the slow pointer which is currently
        // pointing to the middle node of the linked list
        return slow_ptr.data;
    }

    public void printMiddle1() {
        Node slow = head;
        Node fast = head;
        while(slow.next != null && fast.next !=null){


        }
        if (head != null) {
            int length = getLen();
            Node temp = head;
            int middleLength = length / 2;
            while (middleLength != 0) {
                temp = temp.next;
                middleLength--;
            }
            System.out.print("The middle element is ["
                + temp.data + "]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LinkedListMiddle list = new LinkedListMiddle();
        for (int i = 5; i >= 1; i--) {
            list.pushNode(i);
        }
        list.printNode();
        list.printMiddle();
        System.out.print("The middle element is ["
            + list.getMiddle() + "]");
    }
}
