package defaultpackage;
import java.util.HashMap;
import java.util.Map;

public class PowerOfThree326 {

	public static void main(String[] args) {
		int num = 97;
		boolean ret = isPowerOfThree(num);
		System.out.println("num is power of three? " + ret);
	}
	
	static boolean isPowerOfThree(int n){
//		if (num == 1) return true;
//		int remainder = num%10;
//		if(num%3 == 0 && (remainder == 1 || remainder == 3 || remainder == 7 || remainder == 9) )
//			return true;
//		return false;

		if (n == 1)
            return true;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(9, 2);
        map.put(7, 3);
        map.put(1, 4);
 
        int lastDigit = n % 10;
        if (map.get(lastDigit) == null)
            return false;
 
        int power = map.get(lastDigit);
        double powerOfThree = Math.pow(3, power);
        while (powerOfThree <= n) {
            if (powerOfThree == n)
                return true;
            power = power + 4;
            powerOfThree = Math.pow(3, power);
        }
        return false;
	}

}
