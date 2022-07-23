package linkedlist;

import linkedlist.DeleteNode.ListNode;

public class ReverseList {	
	static class LinkListReverse {
		ListNode head;
		LinkListReverse(ListNode n){
			head = n;
		}
		void addNode(ListNode n) {
			ListNode iter = head;
			while(iter.next != null) {
				iter = iter.next;
			}
			iter.next = n;
		}
		
		ListNode reverseList(ListNode oldHead) {
			// create a new node
			// copy over data from original list node into new node
			// point new node next to head
			// point head to new node
			ListNode head = null;
			while(oldHead != null) {
				ListNode newNode = new ListNode(oldHead.val);
				newNode.next = head;
				head = newNode;
				oldHead = oldHead.next;
			}
			return head;
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
		LinkListReverse l = new LinkListReverse(n);

		ListNode n1 = new ListNode(1);
		l.addNode(n1);
		ListNode n2 = new ListNode(2);
		l.addNode(n2);
		ListNode n3 = new ListNode(3);
		l.addNode(n3);
		l.printList(n);
		
		ListNode newReverseList = l.reverseList(l.head);
		l.printList(newReverseList);

	}

}
