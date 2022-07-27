package strings;

public class SubStr28 {

	public static void main(String[] args) {
		String haystack = "hel0liuwebnllkhdfon";
		String needle = "ll";
		int ret = strStr(haystack, needle);
		System.out.println("index of needle in haystack is =" + ret);

	}
	
	// important part is to run outer loop for "haystack.length() - needle.length()" times only.
	static int strStr(String haystack, String needle) {
		int index = -1;
		for(int i =0; i <= haystack.length() - needle.length(); i++) { //i=2, haystack=5
			int j = 1;
			if(haystack.charAt(i) == needle.charAt(0)) {// l == l
				index = i; // index = 2
				while(j < needle.length() && j+i < haystack.length()) {// j=2, needle=2, haystack=5
					if(haystack.charAt(i+j) != needle.charAt(j)) { // l==l
						index = -1;
						break;
					}
					j++;//j=2
				}
				if(index != -1 && j == needle.length()) {
					break;
				} else {
					index = -1;
				}
			}
		}
		
		return index;
	}

}
