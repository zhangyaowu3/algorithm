package 贪心算法.跳跃游戏;

/**
 * leetcode 55 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 *
 * 思路: 从当前位置能够到达某一个位置，那么从当前位置都可以到达某一位置左侧的所有位置。
 */
public class CanJump {

    public boolean canJump(int[] A) {
        int reach = 0;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(i + A[i], reach);
            // 因为reach用的数组，是从0开始的；另外到这个位置即可，故: reach >= n-1
            if (reach >= n - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
