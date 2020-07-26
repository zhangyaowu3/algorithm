package 动态规划;

import java.util.Scanner;

/**
 * leetcode 70
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer inputNum = Integer.valueOf(scanner.next());
        System.out.println(ClimbStairs(inputNum));
    }

    public static int ClimbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
