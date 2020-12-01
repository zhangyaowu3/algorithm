package 算法.排序.前K个高频元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * leetcode 347
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        solution.topKFrequent(nums, k);
    }

    // 先把数据依次放入map的数据结构中，key为出现的值，value出现的次数
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1 );
            } else {
                hashMap.put(num, 1);
            }
        }

        // 使用小顶堆，放入出现频次较高的元素
        PriorityQueue priorityQueue = new PriorityQueue();
        for(Integer key: hashMap.keySet()) {
           if (priorityQueue.size() < k) {
               priorityQueue.add(key);
           } else if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
               priorityQueue.poll();
               priorityQueue.add(key);
           }
        }

        // 取出最小堆的元素
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add((Integer) priorityQueue.remove());
        }
        System.out.println(String.valueOf(res));
        return res;
    }
}
