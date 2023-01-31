/*
Given a Binary Search Tree and a number N, the task is to find the smallest number in the binary
search tree that is greater than or equal to N. Print the value of the element if it exists
otherwise print -1.

Examples:

Input: N = 20
Output: 21
Explanation: 21 is the smallest element greater than 20.

Input: N = 18
Output: 19
Explanation: 19 is the smallest element greater than 18.

Approach:
The idea is to follow the recursive approach for solving the problem i.e. start searching for the
element from the root.

If there is a leaf node having a value less than N, then element doesn’t exist and return -1.
Otherwise, if node’s value is greater than or equal to N and left child is NULL or less than N then
return the node value.
Else if node’s value is less than N, then search for the element in the right subtree.
Else search for the element in the left subtree by calling the function recursively according to
the left or right value.
 */

// Java program to find the smallest value
// greater than or equal to N
class TreeNextSmallestToN
{
    // To create new BST Node
    static TreeNode createNode(int item)
    {
        TreeNode temp = new TreeNode(item);
        temp.data = item;
        temp.left = temp.right = null;
        return temp;
    }

    static TreeNode add(TreeNode node, int key)
    {
        // if tree is empty return new node
        if (node == null)
            return createNode(key);
        // if key is less than or greater than
        // node value then recur down the tree
        if (key < node.data)
            node.left = add(node.left, key);
        else if (key > node.data)
            node.right = add(node.right, key);
        // return the (unchanged) node pointer
        return node;
    }

    static int findMinforN(TreeNode root, int N)
    {
        // If leaf node reached and is smaller than N
        if (root.left == null && root.right == null && root.data < N)
            return -1;

        // If node's value is greater than N and left value
        // is null or smaller then return the node value
        if ((root.data >= N && root.left == null) || (root.data >= N && root.left.data < N))
            return root.data;
        // if node value is smaller than N search in the
        // right subtree
        if (root.data <= N)
            return findMinforN(root.right, N);
            // if node value is greater than N search in the
            // left subtree
        else
            return findMinforN(root.left, N);
    }

    public static void main(String[] args)
    {
	/* 19
		/ \
	7	 21
	/ \
	3	 11
		/ \
		9 14
		*/

        TreeNode root = null;
        root = add(root, 19);
        root = add(root, 7);
        root = add(root, 3);
        root = add(root, 11);
        root = add(root, 9);
        root = add(root, 13);
        root = add(root, 21);

        int N = 18;
        System.out.println(findMinforN(root, N));
    }
}
