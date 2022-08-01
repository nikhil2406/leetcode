package defaultpackage;

public class OneBits191 {

	public static void main(String[] args) {
		int num = -1;
//		System.out.println(7 & num);
		int ret = hammingWeight(num);
		System.out.println("number of 1 bits are=" + ret);
	}
	
	static int hammingWeight(int n) {
		int tmp = 1;
		int count = 0;
		for(int i =0; i < Integer.SIZE; i++) {
			if((n & tmp) > 0) {
				count++;
			}
			tmp = tmp << 1;
		}
		return (n < 0) ? count+1: count;
	}

}
