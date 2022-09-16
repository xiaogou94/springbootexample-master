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

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int ans = 0;
        int rk  = -1;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans,rk + 1 - i);
        }
        return ans;
    }
}
