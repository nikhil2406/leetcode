package strings;

import java.util.HashMap;
import java.util.Stack;

public class MatchBrackets {

	public static void main(String[] args) {
		String s = "((";
		boolean ret = isValid(s);
		System.out.println(ret);

	}

	static boolean isValid(String s) {
		if(s.length() <= 1) return false;
		
		HashMap<Character, Character> h = new HashMap<>();
		h.put('(', ')');
		h.put('{', '}');
		h.put('[', ']');
		
		Stack<Character> stk = new Stack<>();

		// "(("
		int i = 0;
		while(i < s.length()) { //1
			char c = s.charAt(i); //(
			if(h.containsKey(c)) {
				stk.push(h.get(c)); //)
			} else {
				// this char shud match char on top of stack
				if(stk.empty() || c != stk.pop()) {
					return false;
				}
			}
			i++;
		}
		if(!stk.empty()) return false;
		
		return true;

		// better solution
//	     Stack<Character> stack = new Stack();
//	        for(char c : s.toCharArray()) {
//	            if(c=='(')
//	               stack.push(')');
//	            else if(c=='{')
//	                stack.push('}');
//	            else if(c=='[')
//	                stack.push(']');
//	            else if(stack.isEmpty() || stack.pop()!=c) {
//	             //System.out.println(stack);
//	                return false;            
//	            }
//	            
//	       }
//	        //System.out.println(stack);
//	        return stack.isEmpty();
	}

//	static boolean isValidNoSubBracket(String s) {
//		
//		HashMap<Character, Character> h = new HashMap<>();
//		h.put('(', ')');
//		h.put('{', '}');
//		h.put('[', ']');
//		
//		int i = 0;
//		char nextChar = '*';
//		while(i < s.length()) { //2
//			char c = s.charAt(i); //{
//			if(nextChar == '*') {
//				if(h.containsKey(c)) {
//					nextChar = h.get(c); //)
//				} else return false;
//
//			} else {
//				// this is the case when we have seen a starting bracket already
//				if(nextChar == c) { // ) == )
//					nextChar = '*';
//				} else return false;
//			}
//			i++;
//		}
//		
//		return true;
//	}

}
