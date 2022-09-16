package org.jon.lv.Leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/17 13:03
 * @Description:
 */
public class 有效的括号 {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) { // 有效括号
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character,Character> pairs = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
