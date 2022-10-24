package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/21 18:18
 * @Description:
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 */
public class 验证回文串 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }

    // 筛选+判断
    public static boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer stringBufferReverse = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.equals(stringBufferReverse.toString());
    }

    // 双指针
    public static boolean isPalindrome1(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        int n = stringBuffer.length();
        int left = 0,right = n-1;
        while (left < right) {
            if (Character.toLowerCase(stringBuffer.charAt(left)) != Character.toLowerCase(stringBuffer.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
