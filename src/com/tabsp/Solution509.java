package com.tabsp;

import java.util.Arrays;

// https://leetcode-cn.com/problems/fibonacci-number/
public class Solution509 {
    // 递归，最低效，指数级时间复杂度
    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    // 带备忘录的递归，时间复杂度 O(n)，自顶向下
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int[] momo = new int[n + 1];
        Arrays.fill(momo, -1);
        if (momo[n] == -1) {
            momo[n] = fib2(n - 1) + fib2(n - 2);
        }
        return momo[n];
    }

    // 动态规划，时间复杂度 O(n)，自底向上
    public static int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 优化空间复杂度
    public static int fib4(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = curr;
            curr = curr + prev;
            prev = tmp;
        }
        return curr;
    }


    public static void main(String[] args) {
        System.out.println(fib1(20));
        System.out.println(fib2(20));
        System.out.println(fib3(20));
        System.out.println(fib4(20));
    }
}
