public class TreeRighView {

  Node root;
  int max_level;

  void printRightView(Node node, int level){
    if(node == null) return;

    if(max_level < level){
      System.out.print(node.data+" ");
      max_level = level;
    }
    printRightView(node.right, level+1);
    printRightView(node.left, level+1);
  }
  void rightView(){
    max_level = 0;
    printRightView(root, 1);
  }

  public static void main(String[] args) {
    TreeRighView treeRighView = new TreeRighView();
    treeRighView.root = new Node(1);
    treeRighView.root.left = new Node(2);
    treeRighView.root.right = new Node(3);
    treeRighView.root.left.left = new Node(4);
    treeRighView.root.left.right = new Node(5);
    treeRighView.root.right.left = new Node(6);
    treeRighView.root.right.right = new Node(7);
    treeRighView.root.right.left.right = new Node(8);
    treeRighView.rightView();
  }
}
