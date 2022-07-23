// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______3______
//        /              \
//     ___5__          ___1__
//    /      \        /      \
//    6      _2       0       8
//          /  \
//          7   4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


//Definition for a binary tree node.
class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class TreeBinaryLowestCommonAncestor {

  TreeNode root;

  /* Function to find LCA of n1 and n2.The function assumes that both
   n1 and n2 are present in BST
   Time Complexity: O(h).
   The Time Complexity of the above solution is O(h), where h is the height of the tree.
   Space Complexity: O(1).
   The space complexity of the above solution is constant.
 */
  static TreeNode lca(TreeNode root, int n1, int n2) {
    while (root != null) {
      // If both n1 and n2 are smaller
      // than root, then LCA lies in left
      if (root.val > n1 &&
          root.val > n2) {
        root = root.left;
      }

      // If both n1 and n2 are greater
      // than root, then LCA lies in right
      else if (root.val < n1 &&
          root.val < n2) {
        root = root.right;
      } else {
        break;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    // Let us construct the BST shown in the above figure
    TreeBinaryLowestCommonAncestor tree = new TreeBinaryLowestCommonAncestor();
    tree.root = new TreeNode(20);
    tree.root.left = new TreeNode(8);
    tree.root.right = new TreeNode(22);
    tree.root.left.left = new TreeNode(4);
    tree.root.left.right = new TreeNode(12);
    tree.root.left.right.left = new TreeNode(10);
    tree.root.left.right.right = new TreeNode(14);

    int n1 = 10, n2 = 14;
    TreeNode t = lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

    n1 = 14;
    n2 = 8;
    t = lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

    n1 = 10;
    n2 = 22;
    t = lca(tree.root, n1, n2);
    System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

  }

  /*
  * Time Complexity: O(h).
  The time Complexity of the above solution is O(h), where h is the height of the tree.
  Space Complexity: O(h).
  If recursive stack space is ignored, the space complexity of the above solution is constant.
  * */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return left == null ? right : left;
  }
}