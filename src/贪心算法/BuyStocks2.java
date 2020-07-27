package 贪心算法;

/**
 * leetcode 122 买股票2  贪心算法
 */
public class BuyStocks2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int sum = 0;
        for(int i = 1; i< prices.length; i++) {
            int temp = prices[i] - prices[i-1];
            if (temp > 0) {
                sum = sum + temp;
            }
        }
        return sum;
    }
}
