package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/12 19:05
 * @Description: 最长的回文子串
 */
public class 回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) { // 最长回文
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && isPail(cs, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                   }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static boolean isPail(char[] cs, int i, int j) {
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length -1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLength && isPail1(chars,i,j)){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLength);
    }

    private static boolean isPail1(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}
