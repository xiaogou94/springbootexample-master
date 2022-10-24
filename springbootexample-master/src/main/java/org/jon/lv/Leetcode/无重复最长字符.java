package org.jon.lv.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/12 18:57
 * @Description:
 */
public class 无重复最长字符 {
    public static void main(String[] args) {
       String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int len = s.length();
//        int ans = 0;
//        int rk  = -1;
//        for (int i = 0; i < len; i++) {
//            if (i != 0) {
//                set.remove(s.charAt(i - 1));
//            }
//            while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
//                set.add(s.charAt(rk + 1));
//                rk++;
//            }
//            ans = Math.max(ans,rk + 1 - i);
//        }
//        return ans;
//    }



    public static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int rk = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            while (rk < length && !set.contains(str.charAt(rk))) {
                set.add(str.charAt(rk));
                rk++;
            }
            ans = Math.max(ans,rk - i);
        }
        return ans;
    }
}
