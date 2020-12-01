package 算法.双指针法.和为s的连续正整数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer57 和为s的连续正数序列
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class findContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence findContinuousSequence = new findContinuousSequence();
        int target = 15;
        findContinuousSequence.findContinuousSequence(15);
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                sum = sum + j;
                j++;
            } else if (sum > target) {
                sum = sum - i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                System.out.println(Arrays.toString(arr));
                res.add(arr);
                sum = sum - i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
