package strings;

import java.util.Arrays;

public class Palnidrome {

	public static void main(String[] args) {
//		String s = "A man, a plan, a canal Panama";
		String s = "0P";
		boolean out = isPalindrome(s);

		System.out.println("is palnidrome=" + out);
	}
	
	static boolean isPalindrome(String s) {
		String lower = s.toLowerCase();
		char[] tmpArr = new char[lower.length()];
		int lengthOfString = 0;
		
		for(int i =0; i< lower.length(); i++) {
			char c = lower.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
				tmpArr[lengthOfString] = c;
				lengthOfString++;
			}
		}

//		System.out.println(Arrays.toString(tmpArr));
		for(int i = 0; i < lengthOfString/2; i++) {
			if(tmpArr[i] != tmpArr[lengthOfString-1 - i])
				return false;
		}
		return true;
		
		
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
//                i++;
//            }
//            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
//                j--;
//            }
//
//            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
//                return false;
//        }
//
//        return true;
	}
}
