// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

import java.util.ArrayList;
import java.util.List;



  class TreeNode1 {
     int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
 }

public class TreeBinaryTreePaths {
    TreeNode1 root;
    public List<String> binaryTreePaths() {
        List<String> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        helper(new String(), root, result);
        
        return result;
    }
    
    public void helper(String current, TreeNode1 root, List<String> result) {
        if(root.left == null && root.right == null) {
            result.add(current + root.val);
        }

        if(root.left != null) {
            helper(current + root.val + "->", root.left, result);
        }

        if(root.right != null) {
            helper(current + root.val + "->", root.right, result);
        }
    }
    public static void main(String[] args) {
        TreeBinaryTreePaths tree = new TreeBinaryTreePaths();
        tree.root = new TreeNode1(1);
        tree.root.left = new TreeNode1(2);
        tree.root.right = new TreeNode1(3);
        tree.root.left.right = new TreeNode1(5);

        System.out.println(
            "Preorder traversal of binary tree is "+tree.binaryTreePaths());
//        tree.printPreorder();
    }
}
