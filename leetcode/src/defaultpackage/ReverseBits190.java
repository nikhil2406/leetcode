package defaultpackage;
import java.util.List;
import java.util.ArrayList;

public class ReverseBits190 {

	public static void main(String[] args) {
		int num = 11;
		showBits(num);
		
//		int ret = inverseBits(num);
//		System.out.println("\ninverse for number " + num + " is=" + ret);
//		showBits(ret);
		
		int ret = reverseBitsMy(num);
		System.out.println("\nMyreversed number " + num + " is=" + ret);
		showBits(ret);

		ret = reverseBits(num);
		System.out.println("\nreversed number " + num + " is=" + ret);
		showBits(ret);

	}
	static int inverseBits(int n) {
		return ~n;
	}
	
	
	static int reverseBits(int n) {
		int rev = 0;
		 
        // traversing bits of 'n'
        // from the right
        while (n > 0)
        {
            // bitwise left shift
            // 'rev' by 1
            rev <<= 1;
 
            // if current bit is '1'
            if ((int)(n & 1) == 1)
                rev ^= 1;
 
            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
	}
	
	static int reverseBitsMy(int n) {
		int newN = 0;
		for(int i = 0; i < Integer.SIZE; i++) {
			newN = newN << 1;
			if((n & 1) > 0) {
				newN = newN ^ 1;
			}
			n = n >> 1;
		}
		return newN;
	}
	
	static void showBits(int n) {
		List<Integer> l = new ArrayList<>();
		for(int i = 0; i< Integer.SIZE; i++) {
			
			if((n & 1) > 0) l.add(1);
			else l.add(0);
			
			n = n >> 1;
		}
		for(int i = l.size()-1; i >= 0; i--) {
			System.out.print(l.get(i) + ",");
		}
	}

}
