package 数组;

import java.util.HashSet;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 剑指offer 3  数组中重复的数字
 */
public class Solution {

    public static void main(String[] args) {
       Solution solution = new Solution();
       int[] testArr = new int[]{2, 3, 1, 0, 2, 5, 3};
       Integer result = solution.findRepeatNumber(testArr);
       System.out.println(result);

    }

    public Integer findRepeatNumber(int[] testArr) {
        HashSet set = new HashSet();
        for (int value : testArr) {
            if (!set.add(value)) {
                return value;
            }
        }
        return -1;
    }


}
