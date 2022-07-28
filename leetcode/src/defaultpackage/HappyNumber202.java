package defaultpackage;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HappyNumber202 {

	public static void main(String[] args) {
		int num = 13;
		boolean ret = isHappy(num);
		System.out.println("is happy=" + ret);

	}

	// get individual digits from number
	// sort them
	// create a number out of sorted digits
	// store in hashset
	// if store fails the number is not happy because same digits are already
	// present in set
	// else get sum of squares
	// get to step 1
	static boolean isHappy(int n) {
		Set<Integer> s = new HashSet<>();
		List<Integer> l = new ArrayList<>();
		int[] power = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };

		// 19
		int sumSquares = n;
		while (sumSquares != 1) {// 100!=1

			while (sumSquares / 10 != 0) {// 1/10 =0
				l.add(sumSquares % 10);// l=[0,0]
				sumSquares = sumSquares / 10;// 1
			} // add last digit to list as well
			l.add(sumSquares % 10);// l=[0,0,1]

			Collections.sort(l);// l=[0,0,1]

			int sortedNum = 0;
			sumSquares = 0;// reinitialize
			for (int e : l) { // 1
				sortedNum = (sortedNum * 10) + e;// 0+1=1
				sumSquares = sumSquares + power[e];// 0+1=1
			}

			if (sortedNum == 1)
				return true;

			if (s.add(sortedNum) == false) {// s=[19, 28, 68, 1]
				return false;
			}
			l.clear();
		}

		return true;
	}

	// this one doesnt use a hashset to store and compare...its relying on getting
	// to same sum
	// by doing the sum slow and fast
	static boolean isHappyFaster(int n) {
		if (n == 1)
			return true;

		int fast = n;
		int slow = n;
		do {
			if (fast == 1 || slow == 1)
				return true;

			fast = happy(happy(fast));
			slow = happy(slow);
		} while (fast != slow);

		// when fast ans slow are same they shud be 1 as well...otherwise number is not happy
		if (fast == 1)
			return true;

		return false;
	}

	static int happy(int n) {
		int result = 0;

		while (n > 0) {
			result += (n % 10) * (n % 10);
			n /= 10;
		}

		return result;
	}
}
