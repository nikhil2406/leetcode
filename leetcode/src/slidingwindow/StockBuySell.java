package slidingwindow;

public class StockBuySell {

	public static void main(String[] args) {
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {7,6,5,4,3,2,1};
		
		int ret = maxProfit(prices);
		System.out.println("max profit=" + ret);
	}
	
	static int maxProfit(int[] prices) {
		int left = 0; //buy pointer 
		int right = 1; //sell pointer
		int maxP = 0;
		
		while(right < prices.length) { //5<6
			if(prices[right] - prices[left] < 0) { //4-0 = 4
				// move buy pointer to place where right pointer is...we found new low
				left = right; //left=3
			} else if (prices[right] - prices[left] > 0) {
				// see if we got a higher max and move right to next
				maxP = Math.max(maxP, (prices[right] - prices[left])); //maxP=(6, 4)=6
			}
			right++; //5
		}
		
		return maxP;
	}

}
