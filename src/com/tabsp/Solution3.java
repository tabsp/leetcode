package com.tabsp;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        // 右指针
        int right = -1;
        // 左指针，依次后移
        for (int left = 0; left < chars.length; left++) {
            if (left > 0) {
                set.remove(chars[left - 1]);
            }
            if (right == -1) {
                set.add(chars[left]);
                right = 1;
            }
            while (right < chars.length && !set.contains(chars[right])) {
                set.add(chars[right]);
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
