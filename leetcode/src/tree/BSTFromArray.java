package tree;

import tree.DepthOfTree.TreeNode;

public class BSTFromArray {

	static TreeNode sortedArrayToBST(int[] nums) {
		
		return sortedArrayToBSTHelper(nums, 0, nums.length-1);
	}
	
	static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
		// recursive end condition end < start
		// find mid point and add it's value to a new treenode
		// recurse for left subtree and right subtree
		if(end < start) return null;
		int mid = (end+start)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBSTHelper(nums, start, mid-1);
		root.right = sortedArrayToBSTHelper(nums, mid+1, end);
		return root;
	}
	
	static void traverseDFS(TreeNode root) {
		// inorder traversal Left->node->right
		// inroder of BST should give out a ascending order list
		if(root==null) return;
		
		traverseDFS(root.left);
		System.out.println(root.val);
		traverseDFS(root.right);
	}

	public static void main(String[] args) {
		int[] a = {-10,-3,0,5,9};
		TreeNode treeOut = sortedArrayToBST(a);
		
		traverseDFS(treeOut);
	}

}
