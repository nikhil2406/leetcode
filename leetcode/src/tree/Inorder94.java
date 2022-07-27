package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.DepthOfTree.TreeNode;

public class Inorder94 {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.right = new TreeNode(2);
		t.right.left = new TreeNode(3);
		
		List<Integer> ret = inorderTraversalIterative(t);
		for(Integer e: ret) {
			System.out.print(e + ",");
		}

	}
    static List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> l = new ArrayList<>();
    	inorderTraversalHelper(root,l);
    	return l;
    }
    
    static void inorderTraversalHelper(TreeNode r, List<Integer> l) {
    	if(r == null) return;
    	inorderTraversalHelper(r.left, l);
    	l.add(r.val);
    	inorderTraversalHelper(r.right, l);
    }

    static List<Integer> inorderTraversalIterative(TreeNode root) {
    	List<Integer> l = new ArrayList<>();
    	if(root == null) return l;
    	Stack<TreeNode> s = new Stack<>();
    	s.push(root);
    	// push current to stack till current is null...do current = current->left
    	// when current is null , pop from stack and print
    	// move current to current->right
    	// repeat till stack is not empty
    	TreeNode current = root.left;
    	while(s.size() >=0) {
	    	while(current != null) {
	    		s.push(current);
	    		current = current.left;
	    	}
	    	if(s.size()>0) {
	    		current = s.pop();
		    	l.add(current.val);
		    	current = current.right;
	    	} else break;
    	}
    	
    	return l;
    }

}
