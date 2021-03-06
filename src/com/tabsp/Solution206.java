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
        // ??????????????????
        ListNode cur = head;
        // ?????????????????????
        ListNode pre = null;
        while (cur != null) {
            // ????????????????????????????????????
            ListNode next = cur.next;
            // ?????????????????? next ???????????????????????????
            cur.next = pre;
            // ?????? pre
            pre = cur;
            // ?????? cur
            cur = next;
        }
        return pre;
    }

}
