public class TreeTraversalInOrder {

  Node root;

  TreeTraversalInOrder() {
    root = null;
  }

  public static void main(String[] args) {
    TreeTraversalInOrder tree = new TreeTraversalInOrder();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println(
        "\nPostorder traversal of binary tree is ");
    tree.printInorder();
  }

  /* Given a binary tree, print its nodes in inorder
  * Inorder (Left, Root, Right) : 4 2 5 1 3
  * Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
  * */
  void printInorder(Node node) {
    if (node == null) {
      return;
    }

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    System.out.print(node.data + " ");

    /* now recur on right child */
    printInorder(node.right);
  }

  void printInorder() {
    printInorder(root);
  }
}
