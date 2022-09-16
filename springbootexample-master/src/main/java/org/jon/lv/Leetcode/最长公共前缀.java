package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/23 12:22
 * @Description:
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    // 最长公共前缀
    public static String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 0; i < count; i++) {
            prefix = longPrefix(prefix,strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
    private static String longPrefix(String prefix, String str) {
        int length = Math.min(prefix.length(),str.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == str.charAt(index)) {
            index++;
        }
        return prefix.substring(0,index);
    }
}
