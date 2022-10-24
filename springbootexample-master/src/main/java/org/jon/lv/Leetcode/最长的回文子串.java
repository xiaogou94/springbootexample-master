package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/22 09:37
 * @Description:
 */
public class 最长的回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标是否越界，因此先转换为字符数组
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len ; j++) {
                if (j - i + 1> maxLen && validPalindromic(charArray,i,j)) {
                    maxLen  = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    /**
     *  验证是否为回文子串
     * @param charArray
     * @param i
     * @param j
     * @return
     */
    private static boolean validPalindromic(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
