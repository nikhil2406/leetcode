package linkedlist;

import linkedlist.DeleteNode.ListNode;

public class MergeSortedLists21 {

	public static void main(String[] args) {
		ListNode h1 = new ListNode(2);
//		h1.next = new ListNode(1);
//		h1.next.next = new ListNode(7);
		
		ListNode h2 = new ListNode(1);
//		h2.next = new ListNode(3);
//		h2.next.next = new ListNode(4);

		ListNode newHead = mergeTwoLists(h1, h2);
		while(newHead != null) {
			System.out.print(newHead.val + ",");
			newHead = newHead.next;					
		}
	}

	// 2
	// 1
	static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode l1 = list1;
		ListNode l2 = list2;
		ListNode p = null;
		ListNode newHead = null;
		
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		// first value check...to initialize prev node and newhead value correctly 
		if(l1.val <= l2.val) {
			newHead = l1; // new list will start from l1 because l1 is smaller
			p = l1;
			l1 = l1.next;
		} else if(l1.val > l2.val){
			newHead = l2;
			p = l2;
			l2 = l2.next;
		}

		// keep moving the smaller list pointer and have prev point to smaller list
		while(l1 != null && l2 != null) {//l1=7 l2=4
			if(l1.val <= l2.val) { //
				p.next = l1; // 1->1->1
				p = l1; // p=1
				l1 = l1.next; // l1=7
			} else if(l1.val > l2.val) {
				p.next = l2; // 1->1->1
				p = l2; // p=1
				l2 = l2.next; // l1=7
			}
		}
		// when we are out of while we can simply point prev to the larger list
		if(l1 == null) {
			p.next = l2;
		} else if (l2 == null){
			p.next = l1;
		}
		return newHead;

//		ListNode l1 = list1;
//		ListNode l2 = list2;
//		ListNode p = list1;
//		
//		if(list1 == null) return list2;
//		if(list2 == null) return list1;
//
//		while(l1 != null && l2 != null) {//l1=7 l2=4
//			if(l1.val < l2.val) { //
//				p.next = l1; // 1->1->1
//				p = l1; // p=1
//				l1 = l1.next; // l1=7
//			} else if(l1.val > l2.val) {
//				p.next = l2; // 1->1->1
//				p = l2; // p=1
//				l2 = l2.next; // l1=7
//			} else { // 7>4
//				if(p!= list1) {
//					p.next = l2; //1->1->1->3->4
//					p = l2; // p=4
//					l2 = l2.next; //l2=null
//				} else { // 1=1 p=null
//					l1 = l1.next; //l1=1
//					p.next = l2; // 1->1
//					p = l2; // p=l2(1)
//					l2 = l2.next; // l2=3
//				}
//			}
//		}
//		if(l1 == null) {
//			p.next = l2;
//		} else if (l2 == null){
//			p.next = l1;
//		}
//		return list1;
	}
}
