package strings;
import java.util.HashMap;

public class Anagram242 {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "";
		
		boolean ret = isAnagram(s, t);
		System.out.println(ret);

	}

	static boolean isAnagram(String s, String t) {
		//put a string into hashmap
		// traverse another string and remove item found in hashmap
		// if item is not found or hashmap is empty return false
		// if another string is finished and hashmap has entries return false
		HashMap<Character, Integer> set = new HashMap<>();
		for(int i=0; i< s.length(); i++) {
			char ch = s.charAt(i);
			if( set.get(ch) != null ) {
				int tmp = set.get(ch);
				set.put(ch, tmp+1);
			} else {
				set.put(ch, 1);
			}
		}
		
		for(int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (set.get(ch) == null) return false;
			int val = set.get(ch);
			if(val == 1) 
				set.remove(ch);
			else 
				set.put(ch, val-1);
		}

		return (set.size() > 0) ? false : true;
	}
	
// Leet code method of sorting char arrays	
//	public boolean isAnagram(String string1, String string2) {
//        if (string1 == null || string2 == null || string1.length() != string2.length()) {
//            return false;
//        }
//
//        char[] arrString1 = string1.toCharArray();
//        char[] arrString2 = string2.toCharArray();
//        Arrays.sort(arrString1); //nlogn
//        Arrays.sort(arrString2);
//
//        for (int i = 0; i < string1.length(); i++) {
//            if (arrString1[i] != arrString2[i])
//                return false;
//        }
//
//        return true;
//    }
}
