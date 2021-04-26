package com.tabsp;

// https://leetcode-cn.com/problems/string-to-integer-atoi/
public class Solution8 {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        int result = 0;
        int sign = 1;
        int index = 0;
        char c0 = s.charAt(0);
        if (!Character.isDigit(c0) && c0 != '+' && c0 != '-') {
            return 0;
        }
        if (c0 == '-') {
            sign = -1;
        }
        if (!Character.isDigit(c0)) {
            index = 1;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int cur = sign * (s.charAt(index++) - '0');
            if ((Integer.MAX_VALUE / 10) < result || ((Integer.MAX_VALUE / 10 == result) && Integer.MAX_VALUE % 10 < cur)) {
                return Integer.MAX_VALUE;
            }
            if ((Integer.MIN_VALUE / 10) > result || ((Integer.MIN_VALUE / 10 == result) && Integer.MIN_VALUE % 10 > cur)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + cur;
        }
        return result;
    }
}
