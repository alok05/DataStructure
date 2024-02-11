package tree;/* given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height */

public class TreeCreateBinarySearchTree {

    TreeNode createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = createMinimalBST(arr, start, mid - 1);
        treeNode.right = createMinimalBST(arr, mid + 1, end);
        return treeNode;
    }

    TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }
}
