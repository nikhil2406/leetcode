package defaultpackage;
import java.util.Arrays;

public class ArrayRotateArray {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int[] out = {6,7,1,2,3,4,5};
//		int[] a = {1,2};
//		int[] out = {2,1};
		int rotateBy = 3;
		System.out.println("input=" + Arrays.toString(a));
		rotateArray(a, rotateBy);
	}
	
	public static void rotateArray(int[] a, int k){
		int[] newA = a.clone();
		for (int i = 0; i < a.length; i++) {
			int newIdx = i + k;
			if(newIdx >= a.length) {
//				newIdx = Math.abs(a.length - (newIdx));
				newIdx %= a.length;
			}
			newA[newIdx] = a[i];
		}
		System.arraycopy(newA, 0, a, 0, a.length);
		System.out.println("output =" + Arrays.toString(newA));
	}
}

/*
 * 			int newIdx = i + k;
			int tmpP = a[i];
			
			while(newIdx >= k) {
				int tmp = a[newIdx];
				newA[newIdx] = tmpP;
				tmpP = tmp;
				if(newIdx + k > a.length - 1) {
					newIdx = Math.abs(a.length - (newIdx+k));
				} else {
					newIdx += k;
				}
			}
			newA[newIdx] = tmpP;

 */