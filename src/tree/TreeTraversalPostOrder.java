package tree;

public class TreeTraversalPostOrder {

    TreeNode root;

    TreeTraversalPostOrder() {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal.
     Postorder (Left, Right, Root) : 4 5 2 3 1
     Algorithm Postorder(tree)
     1. Traverse the left subtree, i.e., call Postorder(left-subtree)
     2. Traverse the right subtree, i.e., call Postorder(right-subtree)
     3. Visit the root.
    */
    void printPostorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        // first recur on left subtree
        printPostorder(treeNode.left);
        // then recur on right subtree
        printPostorder(treeNode.right);

        // now deal with the node
        System.out.print(treeNode.data + " ");
    }

    void printPostorder() {
        printPostorder(root);
    }

    public static void main(String[] args) {
        TreeTraversalPostOrder tree = new TreeTraversalPostOrder();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println(
            "\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }
}
