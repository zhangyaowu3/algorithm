package 算法.双指针法.两数之和2;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * leetcode 167
 *
 *输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        solution.twoSum(numbers, target);
    }

    public int[]  twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                System.out.println(i);
                System.out.println(j);
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
