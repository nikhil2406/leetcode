package defaultpackage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayIntersection {

	public static void main(String[] args) {
		int[] num1 = {4,9,5,5};
		int[] num2 = {9,4,9,8,5};
		int[] ret = intersect(num1,num2);
		for(int e : ret) {
			System.out.print(e + ",");
		}
		
		HashMap<Integer,Integer> h = new HashMap<>();
		h.put(3, 1);
		h.put(4,1);
		
		ArrayList a = new ArrayList(h.keySet());
		System.out.println(a.toString());
		ArrayList v = new ArrayList(h.values());
		System.out.println(v.toString());

	}
	static int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i =0; i< nums1.length; i++) {
			for(int j=0; j<nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					ret.add(nums1[i]);
					nums2[j] = Integer.MIN_VALUE;
					break;
				}
			}
		}
		int[] retArr = new int[ret.size()];
		for(int i=0; i< ret.size(); i++) {
			retArr[i] = ret.get(i);
		}
		return retArr;
	}
	
//	static int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<nums1.length;i++){
//            for(int j=0;j<nums2.length;j++){
//                if(nums1[i]==nums2[j]){
//                    list.add(nums1[i]);
//                    nums2[j]=-1;
//                    break;
//                }
//            }
//        }
//       int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++){
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
}
