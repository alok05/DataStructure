public class TreeTraversalPreOrder {

  Node root;

  TreeTraversalPreOrder() {
    root = null;
  }

  public static void main(String[] args) {
    TreeTraversalPreOrder tree = new TreeTraversalPreOrder();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println(
        "Preorder traversal of binary tree is ");
    tree.printPreorder();
  }

  /* Given a binary tree, print its nodes in preorder
  Preorder (Root, Left, Right) : 1 2 4 5 3
  * Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree)
  * */
  void printPreorder(Node node) {
    if (node == null) {
      return;
    }

    /* first print data of node */
    System.out.print(node.data + " ");

    /* then recur on left subtree */
    printPreorder(node.left);

    /* now recur on right subtree */
    printPreorder(node.right);
  }

  void printPreorder() {
    printPreorder(root);
  }

}

