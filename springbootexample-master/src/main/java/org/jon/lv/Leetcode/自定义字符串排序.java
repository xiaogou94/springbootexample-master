package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/23 16:31
 * @Description:
 */
public class 自定义字符串排序 {
    public static void main(String[] args) {
         customSortString("cba","abcd");
    }

//    public static String customSortString(String S,String T) {
//        int[] count = new int[26];
//        for (char c:T.toCharArray()) {
//            count[c-'a']++;
//        }
//
//        StringBuffer ans = new StringBuffer();
//        for (char c:S.toCharArray()) {
//            for (int i = 0; i < count[c-'a']; i++) {
//                ans.append(c);
//                count[c-'a'] = 0;
//            }
//        }
//        for (char c = 'a';c<='z';++c) {
//            for (int i = 0; i < count[c-'a']; i++) {
//                ans.append(c);
//            }
//        }
//
//        return ans.toString();
//    }

    public static String customSortString(String order,String s) {
        int[] arr = new int[26];
        for (char c:s.toCharArray()) {
            arr[c-'a']++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c:order.toCharArray()) {
            while (arr[c-'a']-- > 0) {
                stringBuffer.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (arr[i] -- > 0) {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}
