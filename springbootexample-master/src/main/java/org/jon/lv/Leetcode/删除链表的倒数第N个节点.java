package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/17 12:48
 * @Description:
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head,int n) {
//        ListNode dummy = new ListNode(0,head);
//        ListNode first = head;
//        ListNode second = dummy;
//        for (int i = 0; i < n; i++) {
//            first = first.next;
//        }
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//        second.next = second.next.next;
//        ListNode ans = dummy.next;
//        return ans;
        // 删除链表倒数第N个节点
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
