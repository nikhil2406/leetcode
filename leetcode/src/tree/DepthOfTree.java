package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static class Tree {
		int size;
		int depth;
		TreeNode root;
		Tree(){}
		Tree(TreeNode n){
			root = n;
			depth = 1;
		}
		void getTreeSize(TreeNode root) {
			if(root == null) return;
			this.size++;
			this.getTreeSize(root.left);
			this.getTreeSize(root.right);
			return;
		}
		int maxDepthOld(TreeNode root) {
			this.getTreeSize(root);
			System.out.println("size=" + this.size);
			int tmp = this.size;
			while(tmp > 1) {
				this.depth++;
				tmp /= 2;
			}
			return this.depth;
		}

		int maxDepth(TreeNode n) {
			int depth = 0;
			if(n == null) return 0;
			int ldepth = maxDepth(n.left);
			int rdepth = maxDepth(n.right);
			depth = Math.max(ldepth+1, rdepth+1);
			
			return depth;
		}
		
		TreeNode insert(ArrayList<Integer> a, int index) {
			TreeNode root = null;
			if(index < a.size() && a.get(index) != 0) {
				root = new TreeNode(a.get(index));
				if(index == 0) this.root = root;
				root.left = insert(a, 2*index+1);
				root.right = insert(a, 2*index+2);
			}
			return root;
		}
		
		void traverseBFS(TreeNode r) {
			// BFS goes via queue
			// get a queue
			// add root to queue
			// while queue has elements
				// print element
				// add its not null left and right to queue
			System.out.println("===BFS traverse===");
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(r);
			
			while(queue.size() > 0) {
				TreeNode node = queue.poll();
				System.out.print(" " + ((node !=null) ? node.val: "null"));
				
				if(node!= null) {
					queue.add(node.left);
				}
				
				if(node != null) {
					queue.add(node.right);
				}
			}
			System.out.println("\n===BFS traverse ends===");
		}
		
		void traverseDFS(TreeNode n) {
			// DFS uses recursion
			// traverse node and invoke traverse for its left child and right child
			System.out.print(" " + ((n !=null) ? n.val: "null"));
			if(n != null) {
				traverseDFS(n.left);
				traverseDFS(n.right);
			}
		}

		boolean checkMirror(TreeNode a, TreeNode b) {
			if(a == null && b == null) return true;
			if (a == null || b == null) return false;
			
			return a.val == b.val && checkMirror(a.left, b.right) && checkMirror(a.right, b.left);
		}
	}
	
	
	public static void main(String[] args) {
		// construct tree from an array
//		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,0,8,9,0,0,5,6,3,4));
//		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4,3));
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,2,0,3,0,3));


//		TreeNode n1 = new TreeNode(1);
//		TreeNode n2 = new TreeNode(2);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(5);
//		TreeNode n6 = new TreeNode(6);
//		
//		n1.left = n2;
//		n1.right = n3;
//		n3.left = n5;
//		n3.right = n4;
//		n4.right = n6;

		Tree t = new Tree();
		t.insert(input, 0);
		
		t.traverseBFS(t.root);
		
		System.out.println("===DFS traverse===");

		t.traverseDFS(t.root);
		
		System.out.println("\n===DFS traverse ends===");

		int depth = t.maxDepth(t.root);
		
		System.out.println("depth=" + depth);
		
		boolean IsMirror = t.checkMirror(t.root.left, t.root.right);
		System.out.println("miror=" + IsMirror);
	}

}
