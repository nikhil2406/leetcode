package arrays;
import java.util.*;

public class PascalTriangle118 {

	public static void main(String[] args) {
		int num = 5;
		List<List<Integer>> ret = generate(5);
		for(List l: ret) {
			for (int i=0; i< l.size();i++) {
				System.out.print(l.get(i) + ",");
			}
			System.out.print(" : ");
		}

	}
	
	static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> A = new ArrayList<>(numRows);
		A.add(new ArrayList<Integer>(1));
		A.get(0).add(1);
		
		for (int i=1; i < numRows; i++) {
			List curr = new ArrayList<Integer>(i+1);
			A.add(curr);
			curr.add(1);
			for(int j = 1; j < i; j++) {
				curr.add(A.get(i-1).get(j-1) + A.get(i-1).get(j));
			}
			curr.add(1);
		}
		return A;
	}

}
