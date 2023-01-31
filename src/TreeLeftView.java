import java.util.LinkedList;
import java.util.Queue;

/*
Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when
tree is visited from left side.
 */
/* Class to print the left view */
class TreeLeftView {

    static int max_level = 0;
    TreeNode root;

    // function to print left view of binary tree
    private static void printLeftView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int size = queue.size();
            // Traverse all nodes of current level
            for (int i = 1; i <= size; i++) {
                TreeNode temp = queue.poll();
                // Print the left most element at
                // the level
                if (i == 1) {
                    System.out.print(temp.data + " ");
                }
                // Add left node to queue
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                // Add right node to queue
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
    // recursive function to print left view
    /*
    (Using Recursion): The left view contains all nodes that are first nodes in their levels.
    A simple solution is to do level order traversal and print the first node in every level.
    The problem can also be solved using simple recursive traversal. We can keep track of the level
    of a node by passing a parameter to all recursive calls. The idea is to keep track of the maximum
    level also. Whenever we see a node whose level is more than maximum level so far, we print the
    node because this is the first node in its level (Note that we traverse the left subtree before
    right subtree).
    Below is the implementation of the above idea-
    Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n).
    Auxiliary Space: O(n), due to the stack space during recursive call.
    */
    void leftViewUtil(TreeNode treeNode, int level) {
        // Base Case
        if (treeNode == null) {
            return;
        }

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + treeNode.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(treeNode.left, level + 1);
        leftViewUtil(treeNode.right, level + 1);
    }

    // A wrapper over leftViewUtil()
    /*
    (Using Queue): In this method, level order traversal based solution is discussed. If we observe
    carefully, we will see that our main task is to print the left most node of every level. So, we
    will do a level order traversal on the tree and print the leftmost node at every level. Below
    is the implementation of above approach:
    Time Complexity: O(n), where n is the number of nodes in the binary tree.
    Auxiliary Space: O(n) since using space for auxiliary queue
    * */
    void leftView() {
        max_level = 0;
        leftViewUtil(root, 1);
    }
    /* testing for example nodes */
    public static void main(String[] args) {
        /* creating a binary tree and entering the nodes */
        TreeLeftView tree = new TreeLeftView();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.right = new TreeNode(8);
        tree.root.right.right = new TreeNode(15);
        tree.root.right.left = new TreeNode(12);
        tree.root.right.right.left = new TreeNode(14);
        tree.leftView();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right.left = new TreeNode(14);

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);
        tree.leftView();
        printLeftView(root);
    }
}
