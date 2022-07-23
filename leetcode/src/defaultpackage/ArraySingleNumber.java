package defaultpackage;
import java.util.HashSet;

public class ArraySingleNumber {

	public static void main(String[] args) {
		int[] a = {1,2,1};
		
		int uniq = singleNumber(a);
		System.out.println("unique number is = " + uniq);

	}
	
//	static int singleNumber(int[] a) {
//		int out = 0;
//		HashSet<Integer> h = new HashSet<>(a.length/2 + 1);
//		for(int i=0; i < a.length; i++) {
//			if(h.contains(a[i]) == false) {
//				h.add(a[i]);
//			} else {
//				h.remove(a[i]);
//			}
//		}
//		if(h.size() > 0)
//			out = h.iterator().next();
//		return out;
//	}

	// this works when we have repetative numbers in pair of 2...if they are 3 times repeating, it fails.
	static int singleNumber(int[] nums) {
		int output = 0;
	    for(int i = 0; i < nums.length; i++)
	    {
	        output  = output ^ nums[i];
	    }
//	    assert 1 == 2 : "wrong assertion";
	    return output;
	}
	
}
