package tree;

import java.util.ArrayList;
import java.util.Stack;

/*
* Approach: The problem can be solved using only one stack. The idea is to mark each node of the binary
*  tree by assigning a value, called status code with each node such that value 1 represents that the
* node is currently visiting in preorder traversal, value 2 represents the nodes is currently visiting
*  in inorder traversal and value 3 represents the node is visiting in the postorder traversal.

Initialize a stack < pair < Node*, int>> say S.
Push the root node in the stack with status as 1, i.e {root, 1}.
Initialize three vectors of integers say preorder, inorder, and postorder.
Traverse the stack until the stack is empty and check for the following conditions:
If the status of the top node of the stack is 1 then update the status of the top node of the stack to
2 and push the top node in the vector preorder and insert the left child of the top node if it is not
NULL in the stack S.
If the status of the top node of the stack is 2 then update the status of the top node of the stack to
3 and push the top node in the vector inorder and insert the right child of the top node if it is not
NULL in the stack S.
If the status of the top node of the stack is 3 then push the top node in vector postorder and then pop
 the top element.
Finally, print vectors preorder, inorder, and postorder.
* */
class TreeTraversalSingleStack {

    static class Pair {

        TreeNode first;
        int second;

        public Pair(TreeNode first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // Function to print all nodes of a
    // binary tree in Preorder, Postorder
    // and Inorder using only one stack
    static void allTraversal(TreeNode root) {

        // Stores preorder traversal
        ArrayList<Integer> pre = new ArrayList<>();
        // Stores inorder traversal
        ArrayList<Integer> in = new ArrayList<>();
        // Stores postorder traversal
        ArrayList<Integer> post = new ArrayList<>();
        // Stores the nodes and the order
        // in which they are currently visited
        Stack<Pair> s = new Stack<>();
        // Push root node of the tree
        // into the stack
        s.push(new Pair(root, 1));

        // Traverse the stack while
        // the stack is not empty
        while (!s.empty()) {
            // Stores the top
            // element of the stack
            Pair p = s.peek();
            // If the status of top node
            // of the stack is 1
            if (p.second == 1) {
                // Update the status
                // of top node
                s.peek().second++;
                // Insert the current node
                // into preorder, pre[]
                pre.add(p.first.data);
                // If left child is not null
                if (p.first.left != null) {
                    // Insert the left subtree
                    // with status code 1
                    s.push(new Pair(p.first.left, 1));
                }
            }
            // If the status of top node
            // of the stack is 2
            else if (p.second == 2) {
                // Update the status
                // of top node
                s.peek().second++;
                // Insert the current node
                // in inorder, in[]
                in.add(p.first.data);
                // If right child is not null
                if (p.first.right != null) {
                    // Insert the right subtree into
                    // the stack with status code 1
                    s.push(new Pair(p.first.right, 1));
                }
            }
            // If the status of top node
            // of the stack is 3
            else {
                // Push the current node
                // in post[]
                post.add(p.first.data);
                // Pop the top node
                s.pop();
            }
        }
        System.out.print("Preorder Traversal: ");
        for (int i : pre) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Printing Inorder
        System.out.print("Inorder Traversal: ");
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Printing Postorder
        System.out.print("Postorder Traversal: ");
        for (int i : post) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    // Driver Code
    public static void main(String[] args) {
        // Creating the root
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // Function call
        allTraversal(root);
    }
}
