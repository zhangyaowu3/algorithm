package 贪心算法.跳跃游戏;

/**
 * leetcode 55 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 例子:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 */
public class CanJump {
    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        // canJump.canJump(new int[]{2,3,1,1,4});
        canJump.canJump(new int[]{3, 2, 1, 0, 4, 6, 7});
    }

    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果 i > furthest，则说明无法往后跳了
            if (i <= furthest) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) {
                    System.out.println("可以达到");
                    return true;
                }
            }
        }
        System.out.println("不可以达到");
        return false;
    }
}
