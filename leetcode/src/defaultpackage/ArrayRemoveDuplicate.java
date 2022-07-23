package defaultpackage;
import java.util.Arrays;

public class ArrayRemoveDuplicate {

	public static int END_CHAR = 0;
	public static void main(String[] args) {
		int[] input = {-2,-2,-2,2,4,5,5,6,6};
		int[] output = {-2,2,4,5,6,0,0};

//		int[] input = {-2,-1,1,1};
//		int[] output = {-2,-1,1,0};
		
		int k = removeDuplicates(input);
		System.out.println("output length=" + k);
		assert(k==5);
		for(int i = 0; i < output.length; i++) {
			assert(input[i] == output[i]);
			System.out.println(input[i]);
		}

	}

    public static int removeDuplicates(int[] nums) {
	   int index = 0;
       for(int i = 1; i< nums.length;i++){
            if(nums[index] != nums[i]){
               index++;
               nums[index] = nums[i];
           }
       }
//       System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, index+1)));
       return index+1;
   }
       
//    public static int removeDuplicates(int[] nums) {
//        int lenFinal = nums.length;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] == nums[i-1] && nums[i] != END_CHAR){
//                lenFinal --;
//                moveElements(nums, i);
//                i--;
//            }
//        }
//        return lenFinal;
//    }

    static void moveElements(int[] arr, int idx){
        for(; idx < arr.length-1; idx++){
            arr[idx] = arr[idx+1];
        }
        arr[idx] = END_CHAR; // set last element to zero
    }
}
