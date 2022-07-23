package merge;

public class BinarySearch {
	static int badVersion = 1702766719;
	public static void main(String[] args) {
		int version = 2126753390;
		//System.out.println(Integer.MAX_VALUE);
		int ret = firstBadVersion(version);
		System.out.println("returned version=" + ret);

	}
	static int firstBadVersion(int n) {
		return firstBadVersionHelper(1, n);
	}

	static int firstBadVersionHelper(int start, int end){
		while(start <= end) {
//			int mid = (start+end)/2;
			int mid = start + (end - start)/2;
			if(isBadVersion(mid)) {
				// go left
				end = mid-1;
			} else {
				start = mid+1;
			}
			System.out.println(mid);
		}
		return start;
	}
	
//	static int firstBadVersionHelper(int start, int end){
//		if(start > end) return start;
//		int mid = (start+end)/2;
//		if(isBadVersion(mid)) {
//			// go left
//			return firstBadVersionHelper(start, mid-1);
//		} else {
//			return firstBadVersionHelper(mid+1, end);
//		}
//	}
	
	static boolean isBadVersion(int n) {
		if(n >= badVersion) return true;
		return false;
	}

}
