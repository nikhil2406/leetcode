package tree;

import java.util.ArrayList;

import tree.DepthOfTree.TreeNode;

public class CheckBST {

	/*
	static class Tree {
		boolean isBST;
		Tree(){this.isBST = true;}
		public boolean isValidBST(TreeNode root) {
			if((root.left != null && root.left.val >= root.val) 
					|| (root.right != null && root.right.val <= root.val)) return this.isBST = false;
			isValidBSTHelperLeft(root.left, root.val);
			if (this.isBST == false) return this.isBST;
			isValidBSTHelperRight(root.right, root.val);
			return this.isBST;
		}
		public void isValidBSTHelperLeft(TreeNode root, int maxValToCompareAgainst) {
			// if node is null, return
			if(root == null) return;
			// root value should be > left and < right
			// root value should be < tree root
			if(root.left != null) { 
				if(root.left.val <= root.val && root.left.val <= maxValToCompareAgainst){}
				else this.isBST = false;
			}
			if(root.right  != null) {
				if(root.val <= root.right.val && root.right.val <= maxValToCompareAgainst){}
				else this.isBST = false;
			}
			maxValToCompareAgainst = Math.min(maxValToCompareAgainst, root.val);

			isValidBSTHelperLeft(root.left, maxValToCompareAgainst);
			isValidBSTHelperLeft(root.right, maxValToCompareAgainst);
			return;
		}
		public void isValidBSTHelperRight(TreeNode root, int minValToCompareAgainst) {
			if(root == null) return;
			
			if(root.left != null) { 
				if(root.left.val <= root.val && root.left.val >= minValToCompareAgainst){}
				else this.isBST = false;
			}
			if(root.right  != null) {
				if(root.val <= root.right.val && root.right.val >= minValToCompareAgainst){}
				else this.isBST = false;
			}

			minValToCompareAgainst = Math.max(minValToCompareAgainst, root.val);
			isValidBSTHelperRight(root.left, minValToCompareAgainst);
			isValidBSTHelperRight(root.right, minValToCompareAgainst);
			return;
		}
	}
*/
	static class Tree {
		public boolean isValidBST(TreeNode root) {
			boolean isBST = true;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			isBSTHelper(root, arr);
			for(int i = 1; i < arr.size(); i++) {
				if(arr.get(i) <= arr.get(i-1)) {
					isBST = false;
					break;
				}
			}
			return isBST;
		}
		
		void isBSTHelper(TreeNode r, ArrayList<Integer> arr) {
			if(r == null) return;
			
			isBSTHelper(r.left, arr);
			arr.add(r.val);
			isBSTHelper(r.right, arr);
		}
		
//		public boolean isValidBST(TreeNode root) {
//	        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//	    }
//	    public boolean isValidBSTHelper(TreeNode root, int min, int  max) {
//	        // if node is null, return
//	        if(root == null) return true;
//	        // root value should be > left and < right
//	        // root value should be < tree root
//	        if(root.val <= min || root.val > max) { 
//	            return false;
//	        }
//	        return ( isValidBSTHelper(root.left, min, root.val-1) &&
//	        isValidBSTHelper(root.right, root.val+1, max)  );
//	    }
	}
    
	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(1);
//		n1.left = new TreeNode(1);
//		System.out.println(Integer.MIN_VALUE + " " + (Integer.MIN_VALUE-1) + " " + (Integer.MIN_VALUE+1));
//		System.out.println(Integer.MAX_VALUE + " " + (Integer.MAX_VALUE+1) + " " + (Integer.MAX_VALUE-1));
		
		
		TreeNode n1 = new TreeNode(-2147483648);
		n1.left = new TreeNode(-2147483648);
//		n1.right = new TreeNode(4);
//		n1.right.left = new TreeNode(3);
//		n1.right.right = new TreeNode(6);
		
		Tree t = new Tree();
		boolean isBST = t.isValidBST(n1);
		System.out.println("Is BST=" + isBST);
		

	}

}
