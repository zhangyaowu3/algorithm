package 队列栈与堆.最小的K个数;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40  最小的k个数   大顶堆
 *
 * 1, 2, 89, 3, 65, 45, 332, 23  , k = 3
 *
 * 优先队列的底层是二叉堆
 */
public class MinK {

    public static void main(String[] args) {
        MinK minK = new MinK();
        int[] arr = new int[]{1, 2, 89, 3, 65, 45, 332, 23};
        int k = 3;
        minK.MinK(arr, k);
    }

    public int[] MinK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 默认是小顶堆，实现大顶堆需要重新比较器
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        int[] resultArr = new int[queue.size()];
        int idx = 0;
        for (int queueNum : queue) {
            resultArr[idx++] = queueNum;
        }
        System.out.println(resultArr[0] + ":" + resultArr[1] + ":" + resultArr[2]);
        return resultArr;

    }
}
