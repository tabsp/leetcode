package com.tabsp;

// https://leetcode-cn.com/problems/longest-common-subsequence
public class Solution1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || "".equals(text1) || text2 == null || "".equals(text2)) {
            return 0;
        }
        // dp[0][...] 和 dp[...][0] 用来模拟空字符与另一个非空字符串，dp[0][0] 为两个字符串都是空
        // 所以实际存储属性的下标是从 1 开始，到字符串的 length 为止
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
