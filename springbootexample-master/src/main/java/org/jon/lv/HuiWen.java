package org.jon.lv;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/12 19:30
 * @Description:
 */
public class HuiWen {
    public static void main(String[] args) {
        String s = "abcabccbb";
        System.out.println(getMaxLength(s));
    }

    public static int getMaxLength(String s) {
        Set<Character> hashSet = new HashSet<>();
        int length = s.length();
        int ans = 0;
        int rk = -1;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !hashSet.contains(s.charAt(rk + 1))) {
                hashSet.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans,rk + 1 -i);
        }
        return ans;
    }
}
