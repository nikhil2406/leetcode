package defaultpackage;
import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9,8,7,6,5,4,3,2,1,0};
		int[] ret = plusOne(digits);
		
		for(int i=0;i<ret.length;i++) {
			System.out.print(ret[i]);
		}

	}
	static int[] plusOne(int[] digits) {
		// go to end of array
		// if number is 9 make it 0 and keep carry 1
		// keep moving up and check if number is 9 add 1+carry(ifany)
		int carry = 0;
		if(digits[digits.length-1] == 9) {
			carry = 1;
			digits[digits.length-1] = 0;
		} else {
			digits[digits.length -1] += 1;
		}
		for(int i=digits.length-2; i>=0;i--) {
			if(digits[i] == 9 && carry ==1) {
				digits[i] = 0;
				carry = 1;
			} else {
				digits[i] += carry;
				carry = 0;
			}
		}
		if(carry == 1) {
			ArrayList<Integer> newArr = new ArrayList<>();
			for(int e: digits) {
				newArr.add(e);
			}
			newArr.add(1);
			// reverse and return
			int[] ret = new int[newArr.size()];
			for(int i=0; i<= newArr.size()-1; i++) {
				ret[i] = newArr.get(newArr.size() - 1 - i);
			}
			return ret;
		}
		
		return digits;
	}

	static int[] plusOneWithIntegerConstruction(int[] digits) {
		// construct number
		int number =0 ;
		int len = digits.length;
		for(int i =1; i<= len; i++) {
			number += digits[len-i] * Math.pow(10, (i-1));
		}
		// add one
		number++;
		// de construct number
		ArrayList<Integer> newNum = new ArrayList<>();
		while(number > 0) {
			newNum.add(number%10);
			number /= 10;
		}
		// reverse and return
		int[] ret = new int[newNum.size()];
		for(int i=0; i<= newNum.size()-1; i++) {
			ret[i] = newNum.get(newNum.size() - 1 - i);
		}
		return ret;
	}

}
