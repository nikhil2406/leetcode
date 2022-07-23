package defaultpackage;
import java.util.HashMap;
import java.util.HashSet;

public class CheckIfDuplicate {

	public static void main(String[] args) {
		int[] n = {1,2,3,1};
		boolean ret = containsDuplicate(n);
		System.out.println(ret);

	}
	static boolean containsDuplicate(int[] n) {

		HashSet<Integer> h = new HashSet<>();
		for(int i = 0; i< n.length ; i++) {
			boolean ret = h.add(n[i]);
			if(ret == false) {
				return true;
			}
		}
		
		return false;
	}

//	static boolean containsDuplicate(int[] n) {
//
//		HashSet<Integer> h = new HashSet<>();
//		for(int i = 0; i< n.length ; i++) {
//			if(h.contains(n[i])) {
//				return true;
//			} else {
//				h.add(n[i]);
//			}
//		}
//		
//		return false;
//	}

}
