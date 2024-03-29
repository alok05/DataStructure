package tree;// Given an array where elements are sorted in ascending order, convert it to a height
// balanced BST.

public class TreeSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        
        TreeNode root = helper(nums, 0, nums.length - 1);
        
        return root;
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if(start <= end) {
            int mid = (start + end) / 2;
            
            TreeNode current = new TreeNode(nums[mid]);
            
            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);
            
            return current;
        }
        
        return null;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        TreeSortedArrayToBinarySearchTree abst = new TreeSortedArrayToBinarySearchTree();
        abst.sortedArrayToBST(arr);
    }
}
