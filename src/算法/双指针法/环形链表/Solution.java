package 算法.双指针法.环形链表;


/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * leetcode 141
 *
 * 思路: 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(0);
        ListNode m4 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m2;
        solution.hasCycle(m1);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != null && l2!= null && l2.next != null) {
            if (l1 == l2) {
                System.out.println("有环");
                return true;
            }
            l1= l1.next;
            l2 = l2.next.next;
        }
        System.out.println("没有环");
        return false;
    }
}
