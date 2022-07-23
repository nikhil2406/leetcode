package strings;

import java.util.Arrays;

public class reverse {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o'};
		System.out.println("string=" + Arrays.toString(s));
		reverseString(s);
		System.out.println("reverse string=" + Arrays.toString(s));
	}
	
	static void reverseString(char[] s) {
		for(int i = 0; i< s.length/2; i++) {
			char tmp = s[(s.length-1) - i];
			s[(s.length -1) - i] = s[i];
			s[i] = tmp;
		}
		
//		   int left = 0, right = s.length - 1;
//	        while(left < right) {
//	            char tmp = s[left];
//	            s[left++] = s[right];
//	            s[right--] = tmp;
//	        }
	}

}
