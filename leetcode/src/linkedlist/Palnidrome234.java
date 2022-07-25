package linkedlist;
import linkedlist.DeleteNode.ListNode;
import java.util.Stack;

public class Palnidrome234 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(1);

		boolean ret = isPalindrome(head);
		System.out.println("palindrome=" + ret);
	}

// this is fast as well as works for high number of digits
	// find out mid by running a fast and slow pointer
	// reverse the second half of list
	// compare first half with reversed second  half
	static boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null){
            return true;
        }
        ListNode middle = findMiddle(head); // 1st half ka middle dega
        ListNode secondHalfStart = reverse(middle.next); // start of 2nd half
        ListNode firstHalfStart = head;
        while(secondHalfStart!=null){
            if(firstHalfStart.val!=secondHalfStart.val){
                return false;
            }
            firstHalfStart=firstHalfStart.next;
            secondHalfStart=secondHalfStart.next;
        }
        return true;		
	}
	static ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
	}
	static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while(present != null) {
            present.next =prev;
            prev=present;
            present=next;            
            if(next !=null) {
                next =next.next;
            }
        }
          return prev;
	}

// this is fast but doesnt work for lindked list which has elements more than integer max digit count
//	static boolean isPalindrome(ListNode head) {
//		if(head == null) return false;
//		ListNode tmp = head;
//		long number = 0;
//		while (tmp != null) {
//			number = (number * 10) + tmp.val;
//			tmp = tmp.next;
//		}
//		System.out.println("number=" + number);
//		
//		long revDigit = 0;
//		long numberOld = number;
//		while(numberOld >= 1) {
//			revDigit = (revDigit * 10) + (numberOld % 10);
//			numberOld = numberOld/10;
//		}
//		if(revDigit != number) {
//			return false;
//		}
//		return true;
//	}

	// slower method with O(n) space complexity
//	static boolean isPalindrome(ListNode head) {
//		if(head == null) return false;
//		ListNode tmp = head;
//		int size = 1;
//		while (tmp.next != null) {
//			size++;
//			tmp = tmp.next;
//		}
//		if (size == 1) return true;
//		int mid = size/2;
//		boolean isSizeEven = (size%2 == 0) ? true: false;
//		
//		Stack<Integer> s = new Stack<>();
//		int counter = 0;
//		tmp = head;
//		while(counter < mid) {
//			counter++;
//			s.push(tmp.val);
//			tmp = tmp.next;
//		}
//		if(!isSizeEven) {
//			counter++;
//			tmp = tmp.next;
//		}
//		while(counter < size) {
//			int valInStack = s.pop();
//			if(tmp.val != valInStack) return false;
//			counter++;
//			tmp = tmp.next;
//		}
//		return true;
//	}

}
