package likedlist;/* Java program to check if linked list is palindrome recursively */

import java.util.Stack;

class LinkedListPalindrome {
    static class Node {

        int data;
        Node next;

        Node(int d) {
            next = null;
            data = d;
        }
    }
    /*
    * Time complexity: O(n)
      Auxiliary Space: O (n) since we are using an auxiliary stack
    * */
    static boolean isPalindrome(Node head) {
        Node slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if (head.data != i) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condition = isPalindrome(one);
        System.out.println("isPalidrome :" + condition);
    }
}
