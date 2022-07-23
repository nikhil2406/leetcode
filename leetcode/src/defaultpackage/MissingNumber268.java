package defaultpackage;

public class MissingNumber268 {

	public static void main(String[] args) {
//		int[] nums = {};
		int[] nums = {5, 3, 1, 2, 0};
//		int ret = missingNumber(nums);
		int ret = missingNumberLeetCode(nums);
		
		System.out.println("missing number is =" + ret);

	}
	
	static int missingNumber(int[] nums) {
		int len = nums.length;
		int sumNatural = (len * (len+1))/2;
		int sum =0 ;
		for(int e: nums) {
			sum += e;
		}
		
		return sumNatural - sum;
	}

	static int missingNumberLeetCode(int[] nums) {
	    int result = 0;
	    for (int num : nums) {
	        result = result ^ num;
	        System.out.println(result);
	    }
	    System.out.println("-------");
	    for (int i=0; i <= nums.length; i++) {
	        result = result ^ i;
	        System.out.println(result);
	    }
	    return result;
	}
}
