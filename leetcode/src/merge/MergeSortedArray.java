package merge;

public class MergeSortedArray {

	public static void main(String[] args) {
//		int[] num1 = {1,2,3,0,0,0};
//		int[] num2 = {2,5,6};
//		merge(num1, 3, num2, 3);
		int[] num1 = {1};
		int[] num2 = {};
		merge(num1, 1, num2, 0);

		for(int element: num1) {
			System.out.print(element + ",");
		}

	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // copy over nums2 into nums1
		for(int i = m, j=0; i< m+n; i++, j++) {
			nums1[i] = nums2[j];
		}
		// sort the array in place
		for(int i = 1; i< m+n; i++) {
			while(i > 0 && nums1[i] < nums1[i-1]) {
				int tmp = nums1[i-1];
				nums1[i-1] = nums1[i];
				nums1[i] = tmp;
				i--;
			}
		}
    }
}
