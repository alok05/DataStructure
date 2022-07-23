public class TreeTraversalPostOrder {

  Node root;

  TreeTraversalPostOrder() {
    root = null;
  }

  public static void main(String[] args) {
    TreeTraversalPostOrder tree = new TreeTraversalPostOrder();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println(
        "\nPostorder traversal of binary tree is ");
    tree.printPostorder();
  }

  /* Given a binary tree, print its nodes according to the
  "bottom-up" postorder traversal.
   Postorder (Left, Right, Root) : 4 5 2 3 1
   Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
  */
  void printPostorder(Node node) {
    if (node == null) {
      return;
    }
    // first recur on left subtree
    printPostorder(node.left);
    // then recur on right subtree
    printPostorder(node.right);

    // now deal with the node
    System.out.print(node.data + " ");
  }

  void printPostorder() {
    printPostorder(root);
  }
}
