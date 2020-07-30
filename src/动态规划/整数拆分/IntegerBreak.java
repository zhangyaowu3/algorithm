package 动态规划.整数拆分;

/**
 * leetcode 343 整数拆分  这道题依然不是很懂
 */
public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreak integerHandle = new IntegerBreak();
        integerHandle.integerBreak(10);
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
//        if (n == 2) {
//            return 1;
//        }
//        if (n == 3) {
//            return 2;
//        }
        // 结论出现
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <=n; i++) {
            // 一个位置一个位置往后切
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }
}
