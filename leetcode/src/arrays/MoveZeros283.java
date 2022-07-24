package arrays;

public class MoveZeros283 {

	public static void main(String[] args) {
		int[] nums = {1,1};
//		int[] nums = {1,0,4,0,3,12,10};
		moveZeroes(nums);
		for(int e: nums) {
			System.out.print(e + ",");
		}

	}

    static void moveZeroes(int[] nums) {
    	// traverse array swap zero with first non zero element
    	// increment to next index
//    	int runTheLoop = nums.length;
    	int j =1;
    	for(int i =0; j < nums.length; i++) {//i=4 run=4
    		if(nums[i] == 0) {
    			// move towards right
    			while(j < nums.length && nums[j] ==0) {//6<7 nums[6]=10
    				j++;//j=6
    			}
    			// swap 0 with first non-zero on right
    			if(j < nums.length) { //6<7
	    			nums[i] = nums[j];//i=4 j=6 
	    			nums[j] = 0;//1 4 3 12 10 0 0
    			}
//    			runTheLoop-= 1;//run=3
    		} else {j++;}
    	}
    }
}
