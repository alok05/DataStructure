package tree;

public class TreeRighView {

    TreeNode root;
    int max_level;

    void printRightView(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(treeNode.data + " ");
            max_level = level;
        }
        printRightView(treeNode.right, level + 1);
        printRightView(treeNode.left, level + 1);
    }

    void rightView() {
        max_level = 0;
        printRightView(root, 1);
    }

    public static void main(String[] args) {
        TreeRighView treeRighView = new TreeRighView();
        treeRighView.root = new TreeNode(1);
        treeRighView.root.left = new TreeNode(2);
        treeRighView.root.right = new TreeNode(3);
        treeRighView.root.left.left = new TreeNode(4);
        treeRighView.root.left.right = new TreeNode(5);
        treeRighView.root.right.left = new TreeNode(6);
        treeRighView.root.right.right = new TreeNode(7);
        treeRighView.root.right.left.right = new TreeNode(8);
        treeRighView.rightView();
    }
}
