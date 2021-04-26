package com.tabsp;

// https://leetcode-cn.com/problems/add-two-numbers/
public class Solution2 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }
        if (carry > 0) {
            cursor.next = new ListNode(carry);
        }
        return root.next;
    }
}
