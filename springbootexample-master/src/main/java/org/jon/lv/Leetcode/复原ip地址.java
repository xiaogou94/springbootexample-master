package org.jon.lv.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/23 10:54
 * @Description:
 */
public class 复原ip地址 {


    public static void main(String[] args) {
       String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    // 复原ip
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(s,0,ans,temp);
        return ans;
    }
    private static void backTracking(String s, int begin, List<String> ans, List<String> temp) {
       if (temp.size() == 4) {
           if (begin == s.length()) {
               ans.add(String.join(".",temp));
           }
           return;
       }
        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            String sub = s.substring(begin,i+1);
            if (!isRang(sub)) {
                continue;
            }
            temp.add(sub);
            backTracking(s,i+1,ans,temp);
            temp.remove(temp.size() - 1);
        }
    }
    private static boolean isRang(String sub) {
        if (sub.length() != 1 && sub.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(sub) <= 255? true : false;
    }

}
