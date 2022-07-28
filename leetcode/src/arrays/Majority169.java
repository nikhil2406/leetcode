package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class Majority169 {

	public static void main(String[] args) {
//		int[] nums = {2,2,1,1,1,2,2,2};
		int[] nums = {10,9,9,9,10};
		int ret = majorityElement(nums);
		System.out.println("majority element is=" + ret);
	}

//	static int majorityElement(int[] nums) {
//		Hashtable<Integer, Integer> h = new Hashtable<>();
//		int len = nums.length; //3
//		if(len == 1) return nums[0];
//		
//		int half = len/2; // 1
//		for(int i = 0; i < len; i++) {
//			if(!h.containsKey(nums[i])) { //h=[{3,1},{2,1}], 3
//				h.put(nums[i], 1); // h=[{3,1},{2,1}]
//			} else {
//				int val = h.get(nums[i]); //1
//				val++;
//				if(val > half) return nums[i];//1 > 1-1 false
//				h.put(nums[i], val); // h=[{3,2},{2,1}]
//			}
//		}
//
//		return -1; // its mentioned in question that there will always be a value
//	}
	
	// {2,2,1,1,1,2,2}
	// this one is without extra space
//	static int majorityElement(int[] nums) {
//		Arrays.sort(nums); //{1,1,1,2,2,2,2}
//		int index = 1;
//		int max = 1;
//		int cur = nums[0];//1
//		while(index < nums.length) {//6<7
//			if(nums[index] == cur) {//2==2
//				max++; // 4
//			} else {
//				cur = nums[index]; // cur=2
//				max = 1; // 1
//			}
//			if (max > nums.length/2) break;
//			index++; //6
//		}
//		return cur;
//	}

	// trying to make it more faster by removing Arrays.sort. This is 100% faster
	// important assumption is that array has always got one majority element
	// {1,9,1,9,1}
	static int majorityElement(int[] nums) {
//		Arrays.sort(nums);
		int index = 1;
		int max = 1;
		int cur = nums[0];//1
		while(index < nums.length) {//4<5
			if(nums[index] == cur) {//1!=9
				max++; // 
			} else {
				max--; // 0
			}
			// we change cur only when previous max element is not seen max times
			// basically other elements are cancelling out the max element's count.
			// At the end cur element will be last man standing
			if (max == 0) { 
				cur = nums[index]; // cur = 1
				max = 1;
			};
			index++; //5
		}
		return cur;
	}

}
