package com.tabsp;

// https://leetcode-cn.com/problems/reverse-linked-list/
public class Solution206 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *       +------+       +-----+       +-----+       +-----+
     * 0.    |  1   | ----> |  2  | ----> |  3  | ----> |  4  | ----> null
     *       +------+       +-----+       +-----+       +-----+
     *
     *               +------+       +-----+       +-----+       +-----+
     * 1.   null     |  1   | ----> |  2  | ----> |  3  | ----> |  4  | ----> null
     *       ^       +------+       +-----+       +-----+       +-----+
     *       |          ^              ^
     *       |          |              |
     *      pre        cur           next
     *                                          ||
     *                                          ||
     *                                          V
     *                  +------+       +-----+       +-----+       +-----+
     * 2.   null <---- |  1   |       |  2  | ----> |  3  | ----> |  4  | ----> null
     *                 +------+       +-----+       +-----+       +-----+
     *                    ^              ^              ^
     *                    |              |              |
     *                   pre            cur           next
     *                                          ||
     *                                          ||
     *                                          V
     *                  +------+        +-----+       +-----+       +-----+
     * 3.   null <---- |  1   | <----  |  2  |       |  3  | ----> |  4  | ----> null
     *                 +------+        +-----+       +-----+       +-----+
     *                                    ^              ^            ^
     *                                    |              |            |
     *                                   pre            cur         next
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 储存当前节点
        ListNode cur = head;
        // 储存前一个节点
        ListNode pre = null;
        while (cur != null) {
            // 首先将下一个节点缓存下来
            ListNode next = cur.next;
            // 将当前节点的 next 指针指向前一个节点
            cur.next = pre;
            // 后移 pre
            pre = cur;
            // 后移 cur
            cur = next;
        }
        return pre;
    }

}
