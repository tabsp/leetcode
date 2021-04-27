package com.tabsp;

// https://leetcode-cn.com/problems/climbing-stairs/
public class Solution70 {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 优化空间复杂度
    public static int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int p = 1;
        int q = 2;
        for (int i = 3; i <= n; i++) {
            int c = p + q;
            p = q;
            q = c;
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }
}
