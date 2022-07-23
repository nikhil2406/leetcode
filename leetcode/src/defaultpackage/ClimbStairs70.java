package defaultpackage;
import java.util.Hashtable;

public class ClimbStairs70 {

	static int[] h = new int[45];
	
	public static void main(String[] args) {
		int stairs = 45;
		int ret = climbStairs(stairs);
		System.out.println("ways to climb " + stairs + " stairs are = " + ret);
	}
	static int climbStairs(int n) {
		if(n == 1) return 1;
		if(n ==2) return 2;
		
		if(h[n-1] == 0) {
			h[n-1] = climbStairs(n-1);
		}
		
		if(h[n-2] == 0) {
			h[n-2] = climbStairs(n-2);
		}
		
		return h[n-1]+ h[n-2];
		
	}

}
