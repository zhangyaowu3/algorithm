package 滑动窗口;

import java.util.HashMap;

import static java.lang.Math.max;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * leetcode 3
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer result = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            System.out.println(map );
            maxLen= max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
