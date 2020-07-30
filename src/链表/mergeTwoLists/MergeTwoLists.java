package 链表.mergeTwoLists;

/**
 *  leetcode 21 合并两个有序链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (null != l1 && null != l2) {
            if(l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (null != l1) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (null != l2) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        System.out.println(dummy.val);
        System.out.println(dummy.next.val);
        System.out.println(dummy.next.next.val);

        return dummy.next;
    }

    public static void main(String [] args) {
        MergeTwoLists mergeHandle = new MergeTwoLists();
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        mergeHandle.mergeTwoLists(m1, n1);
    }
}
