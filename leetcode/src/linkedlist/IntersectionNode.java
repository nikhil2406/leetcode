package linkedlist;

import linkedlist.DeleteNode.ListNode;

public class IntersectionNode {

	public static void main(String[] args) {
		ListNode root1 = new ListNode(4);
		root1.next = new ListNode(1);
		root1.next.next = new ListNode(8);
		root1.next.next.next = new ListNode(4);
		root1.next.next.next.next = new ListNode(5);
		
		ListNode root2 = new ListNode(5);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(1);
		root2.next.next.next = root1.next.next;
		root2.next.next.next.next = root1.next.next.next;
		root2.next.next.next.next.next = root1.next.next.next.next;

		ListNode out = getIntersectionNode(root1, root2);
		if(out != null) System.out.println(out.val);
	}
	
	 static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 // find size of both linked lists
		 // move longer list root such that lists are same length
		 // traverse both lists in parallel comparing values
		 int sizeA=0, sizeB = 0;
		 int finalSize = 0;
		 ListNode a = headA;
		 ListNode b = headB;
		 while(a != null) {sizeA++; a=a.next;}
		 while(b != null) {sizeB++; b=b.next;}
		 
		 if(sizeA > sizeB) {
			 finalSize = sizeB;
			 headA = moveListBy(headA, sizeA-finalSize);
			 System.out.println(headA.val);
		 } else {
			 finalSize = sizeA;
			 headB = moveListBy(headB, sizeB - finalSize);
			 System.out.println(headB.val);
		 }
		 
		 while(finalSize >0) {
			 if(headA == headB) return headA;
			 headA= headA.next;
			 headB=headB.next;
			 finalSize--;
		 }
		 return null;
	 }
	 
	 static ListNode moveListBy(ListNode l, int size) {
		 while(size > 0) {
			 l = l.next;
			 size--;
		 }
		 return l;
	 }
}
