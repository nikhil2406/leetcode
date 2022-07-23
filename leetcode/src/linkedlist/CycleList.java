package linkedlist;

import linkedlist.DeleteNode.ListNode;

public class CycleList {

	static class LinkList {
		ListNode head;
		LinkList(ListNode n){
			head = n;
		}
		void addNode(ListNode n) {
			ListNode iter = head;
			while(iter.next != null) {
				iter = iter.next;
			}
			iter.next = n;
		}
		
		boolean hasCycle(ListNode head) {
			// slow pointer moves 1 and fast pointer 2
			// when fast.next equals slow we get loop
			ListNode slow = head;
			ListNode fast = head;
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if(slow == fast) return true;
			}
			return false;
		}
		
		void printList(ListNode head) {
			System.out.println("\n=======");
			if(head == null) return;
			ListNode iter = head;
			while(iter.next != null) {
				System.out.print(iter.val + " ");
				iter = iter.next;
			}
			System.out.print(iter.val + " ");
		}
	}

	public static void main(String[] args) {
		ListNode n = new ListNode(0);
		LinkList l = new LinkList(n);

		ListNode n1 = new ListNode(1);
		l.addNode(n1);
		ListNode n2 = new ListNode(2);
		l.addNode(n2);
		ListNode n3 = new ListNode(3);
		l.addNode(n3);
		ListNode n4 = new ListNode(4);
		l.addNode(n4);
//		n4.next = n1;
		
		boolean cycle = l.hasCycle(l.head);
		System.out.println("list has cycle=" + cycle);
	}

}
