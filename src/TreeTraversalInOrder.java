public class TreeTraversalInOrder {

    TreeNode root;

    TreeTraversalInOrder() {
        root = null;
    }
    /* Given a binary tree, print its nodes in inorder
    * Inorder (Left, Root, Right) : 4 2 5 1 3
    * Algorithm Inorder(tree)
     1. Traverse the left subtree, i.e., call Inorder(left-subtree)
     2. Visit the root.
     3. Traverse the right subtree, i.e., call Inorder(right-subtree)
    * */
    void printInorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        /* first recur on left child */
        printInorder(treeNode.left);
        /* then print the data of node */
        System.out.print(treeNode.data + " ");
        /* now recur on right child */
        printInorder(treeNode.right);
    }

    void printInorder() {
        printInorder(root);
    }

    public static void main(String[] args) {
        TreeTraversalInOrder tree = new TreeTraversalInOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println(
            "\nPostorder traversal of binary tree is ");
        tree.printInorder();
    }
}
