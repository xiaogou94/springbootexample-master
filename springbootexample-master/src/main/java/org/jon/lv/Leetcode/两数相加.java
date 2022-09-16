package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/11 22:56
 * @Description:
 */
public class 两数相加 {

    public ListNode addTwoNumbers (ListNode l1,ListNode l2) {
        // 定义一个新链表伪指针,用来指向头指针，返回结果
//        ListNode prev = new ListNode(0);
//        // 定义一个进位的数的指针，用来存储当两数之和大于10的时候
//        int carry = 0;
//        // 定义一个可移动的指针，用来指向存储两个数之和位置
//        ListNode cur = prev;
//        // 当l1 不等于null 或者l2 不等于空的时候就进入循环
//        while (l1 != null || l2 != null) {
//            // 如果l1 不等于null时候 就取他的值，等于null时候，就赋值伪0 保持两个链表具有相同的位数
//            int x = l1 != null ? l1.val : 0;
//            int y = l2 != null ? l2.val : 0;
//            // 将两个链表的值，进行相加，并加上进位数
//            int sum = x + y + carry;
//            // 计算进位数
//            carry = carry / 10;
//            // 计算两个数之和，此时排除超过10的情况（大于10，取余数）
//            sum = sum % 10;
//            // 将求和赋值给新链表的节点
//            // 注意这个时候不能直接将sum赋值给cur.next = sum,这时候会报，类型不匹配
//            cur.next = new ListNode(sum);
//            // 将新链表节点后移
//            cur = cur.next;
//            // 当链表l1不等于null的时候，将l1节点后裔
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//        // 如果最后的两个数，相加的时候有进位的时候，就将进位数，赋予链表的新节点
//        // 两数相加最多小于20，所以的值最大只能1
//        if (carry == 1) {
//            cur.next = new ListNode(carry);
//        }
//        // 返回链表的头点
//        return prev.next;
//        ListNode prev = new ListNode(0);
//        ListNode cur = prev;
//        int carry = 0;
//        while (l1 != null || l2 != null || carry != 0) {
//            int x = l1.val;
//            int y = l2.val;
//            int sum = x + y + carry;
//            carry = sum / 10 ;
//            sum = sum % 10;
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//            if (carry == 1) {
//                cur.next = new ListNode(carry);
//            }
//        }
//        return prev.next;
        ListNode prev = new ListNode(0);
        ListNode cur = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1.val;
            int y = l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
        }
        return prev.next;
    }
}
