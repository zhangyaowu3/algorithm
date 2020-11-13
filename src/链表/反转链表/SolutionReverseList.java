package 链表.反转链表;


/**
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * leetcode 206  反转链表
 *
 * 博客: https://www.cnblogs.com/jay-huaxiao/p/12286133.html
 */
public class SolutionReverseList {
    public static void main(String[] args) {
        SolutionReverseList solutionReverseList = new SolutionReverseList();

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;
        solutionReverseList.reverseList(m1);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

}
