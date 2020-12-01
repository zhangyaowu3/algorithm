package 算法.双指针法.验证回文字符串2;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 *
 * leetcode 680
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abca";
        solution.validPalindrome(s);
    }

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                // 当两者不相等时，既可以删除i位置的值，也可以删除j位置的值
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        System.out.println("true");
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

}
