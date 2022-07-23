package strings;

import java.util.ArrayList;

public class FirstUniqueChar {

	public static void main(String[] args) {
//		String s = "leetcodeltcod";
		String s = "leelk";
		int ret = firstUniqChar(s);
		System.out.println("uniq char index = " + ret);
	}
	
	static int firstUniqChar(String s)  {
		int index = -1;
//		ArrayList<Integer> allChars = new ArrayList<>(52);
		int[] allChars = new int[26];
		for(int i = 0; i < s.length(); i++) {
			int charIndex = s.charAt(i) - 'a';
			allChars[charIndex]++;
		}
		
		for(int i = 0; i < s.length(); i++) {
			int indexInAllChar = s.charAt(i) - 'a';
			if(allChars[indexInAllChar] == 1) {
				return i;
			}
		}		
		return index;
		
		
//			if(s.length()< 0) return -1;
//	        if(s.length() == 1) return 0;
//	        for(int i=0;i<s.length();i++){
//	            char ch = s.charAt(i);
//	            if(s.indexOf(ch) == s.lastIndexOf(ch)){
//	                return i;
//	            }
//	            
//	        }
//	        return -1;
	}

}
