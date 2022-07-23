package strings;

import java.util.Hashtable;

public class LongestPrefix14 {

	public static void main(String[] args) {
//		String[] strs = {""};
//		String[] strs = {"flower", "dog", "cat"};
		String[] strs = {"flower", "flow", "floor"};
	    String ret = longestCommonPrefix(strs);
	    
	    System.out.println("returned longest prefix is =" + ret + ":");

	}

    static String longestCommonPrefix(String[] strs) {
    	int largestMatch=strs[0].length();
    	if(strs.length == 0) return "";
    	if(strs.length == 1) return strs[0];
    	
    	for(int i=1; i< strs.length; i++) {
    		int currentMatch=0;
    		int j =0;
    		while( (j < strs[i].length() && j < largestMatch)
    				&& (strs[0].charAt(j) == strs[i].charAt(j)) ) {
    			currentMatch++;
    			j++;
    		}
    		largestMatch = Math.min(largestMatch, currentMatch);
    	}

    	return strs[0].substring(0, largestMatch);
    }

//    static String longestCommonPrefix(String[] strs) {
//    	int largestMatch=Integer.MAX_VALUE;
//    	Hashtable<Integer, Character> h = new Hashtable<>();
//    	for(int i=0; i < strs[0].length();i++) {
//    		h.put(i, strs[0].charAt(i));
//    	}
//    	
//    	for(int i=1; i< strs.length; i++) {
//    		int currentMatch=0;
//    		String tmp = strs[i];
//    		int j =0;
//    		while(j < tmp.length()) {
//    			// compare characters in string with hashtable
//    			if(h.get(j) == tmp.charAt(j)) {
//    				currentMatch++;
//    			} else {
//    				break;
//    			}
//    			j++;
//    		}
//    		largestMatch = Math.min(largestMatch, currentMatch);
//    	}
//    	StringBuffer ret = new StringBuffer();
//    	int i = 0;
//    	while(i < largestMatch) {
//    		ret.append(h.get(i));
//    		i++;
//    	}
//    	
//    	return ret.toString();
//    }

}
