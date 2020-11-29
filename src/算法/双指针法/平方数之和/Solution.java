package 算法.双指针法.平方数之和;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * leetcode 633
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.judgeSquareSum(9);
    }

    public boolean judgeSquareSum(int c) {
        if(c == 0) {
            return true;
        }
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i < j) {
            if (i*i + j*j > c) {
                j = j-1;
            }
            if (i*i + j*j <c) {
                i = i+1;
            }
            if (i*i + j*j == c) {
                System.out.println("true");
                return true;
            }
        }
        return false;
    }
}
