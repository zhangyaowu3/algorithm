package 算法.双指针法.反转字符串中的元音字符;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 *
 * leetcode 345
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        solution.reverseVowels(s);
    }

    public String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = s.length()-1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
              result[i++] = cj;
              result[j--] = ci;
            }

        }
        System.out.println(String.valueOf(result));
        return new String(result);
    }
}
