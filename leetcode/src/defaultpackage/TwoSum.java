package defaultpackage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
//		int[] nums = {2,4,6,7,11,15};
//		int target = 11;
		int[] nums = { 2, 5, 5, 11 };
		int target = 10;
		int[] ret = twoSum(nums, target);

		for (int i : ret) {
			System.out.print(i + ",");
		}
	}

	static int[] twoSumForsortedArray(int[] nums, int target) {
		// use binary search
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1; // 2
			int end = nums.length - 1; // 5
			while (start <= end) { // 2<=5
				int mid = start + (end - start) / 2; // 2+1=3
				if (nums[i] + nums[mid] == target) { // 4+7==11
					ret[0] = i;
					ret[1] = mid;
					return ret;
				} else if (nums[i] + nums[mid] < target) { // 2+11<11
					// go right
					start = mid + 1; // 4
				} else { // 2+11>11
					// go left
					end = mid - 1; // 3
				}
			}
		}
		return ret;
	}

	static int[] twoSumNSquare(int[] nums, int target) {
		int[] ret = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
		return ret;
	}

	// this solution uses hashmap and gets it done faster
	static int[] twoSumWithHash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			// check if map has a key which will give 'target' and ensure its not same as
			// current key
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				return new int[] { i, map.get(target - nums[i]) };
			}
		}

		return new int[] { -1, -1 };
	}

	// this one is more optimum as it traverse and builds hashmap in one iteration
	static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (seen.containsKey(target - nums[i])) {
				int[] ret = new int[] { i, seen.get(target - nums[i]) };
				Arrays.sort(ret);
				return ret;
			}

			seen.put(nums[i], i);
		}

		return null;
	}
}
