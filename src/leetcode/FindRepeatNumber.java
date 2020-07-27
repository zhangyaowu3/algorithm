package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指offer03  数组中重复的数字
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[] {2, 3, 1, 0, 2, 5, 3}));
    }

/*    public static int findRepeatNumber(int[] nums) {
        Map map = new HashMap();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsValue(nums[i])) {
                return nums[i];
            } else {
                map.put(i,nums[i]);
            }
        }
        return -1;
    }*/

    public static int findRepeatNumber(int[] nums) {
        Set set = new HashSet();
        for(int i = 0; i< nums.length; i++) {
           if(!set.add(nums[i])) {
              return nums[i];
           }
        }
        return -1;
    }
}
