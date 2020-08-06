package 队列栈与堆.数据流的中位数;

import java.util.PriorityQueue;

/**
 * leetcode 295
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如:
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 *
 * 思路：一个大顶堆放"前有序数组"，一个小顶堆放"后有序数组"   与或运算
 *
 */
public class MedianFinder {

    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<>((v1,v2) -> (v2-v1));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        // 先放入大顶堆中排序再放入小顶堆中排序
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        // 如果count是奇数,小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) == 1) {
          maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        // 判断count为奇数还是偶数
        if((count & 1) == 0) {
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }
}
