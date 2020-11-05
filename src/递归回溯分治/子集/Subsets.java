package 递归回溯分治.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78  有空需要再看下一下
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        Subsets subsets = new Subsets();

        List<List<Integer>> res = new ArrayList<>();
        subsets.backtrack(0,nums,res, new ArrayList<Integer>());
        System.out.println(String.valueOf(res));
    }

    public void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));  // 空数组
        for(int j = i ;j< nums.length; j++) {
            tmp.add(nums[j]);
            System.out.println("tmp的值" + String.valueOf(tmp));
            System.out.println("res值" + String.valueOf(res));
            backtrack(j+1 ,nums,res,tmp);
            System.out.println("删除前的值" + String.valueOf(tmp));
            tmp.remove(tmp.size() - 1);
            System.out.println("删除后的值" + String.valueOf(tmp));
        }
    }


}
