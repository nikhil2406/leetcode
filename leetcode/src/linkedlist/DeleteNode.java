package linkedlist;

public class DeleteNode {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
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
		void deleteNodeAny(ListNode n) {
			if(head == n) {
				head = n.next;
				return;
			}
			ListNode iter = head;
			while(iter.next != null && iter.next != n) {
				iter = iter.next;
			}
			if(iter.next == null) { // last node dont delete
				System.out.println("\ndidnt find node");
			} else {
				iter.next = n.next;
			}
		}
		void deleteNode(ListNode n) {
			// node is somewhere before tail
			n.val = n.next.val;
			n.next = n.next.next;
		}
		void printList() {
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
		ListNode nd = new ListNode(2);
		l.addNode(nd);
		ListNode n2 = new ListNode(3);
		l.addNode(n2);
		l.printList();

		ListNode n3 = new ListNode(4); // not added in linked list
		l.deleteNode(n1);
		l.printList();
	}

}
