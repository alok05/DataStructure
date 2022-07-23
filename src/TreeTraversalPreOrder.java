public class TreeTraversalPreOrder {

    TreeNode root;

    TreeTraversalPreOrder() {
        root = null;
    }

    /* Given a binary tree, print its nodes in preorder
    Preorder (Root, Left, Right) : 1 2 4 5 3
    * Algorithm Preorder(tree)
     1. Visit the root.
     2. Traverse the left subtree, i.e., call Preorder(left-subtree)
     3. Traverse the right subtree, i.e., call Preorder(right-subtree)
    * */
    void printPreorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        /* first print data of node */
        System.out.print(treeNode.data + " ");

        /* then recur on left subtree */
        printPreorder(treeNode.left);

        /* now recur on right subtree */
        printPreorder(treeNode.right);
    }

    void printPreorder() {
        printPreorder(root);
    }

    public static void main(String[] args) {
        TreeTraversalPreOrder tree = new TreeTraversalPreOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println(
            "Preorder traversal of binary tree is ");
        tree.printPreorder();
    }
}
