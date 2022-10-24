package org.jon.lv.Leetcode;

import java.util.Scanner;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/09 12:10
 * @Description:
 */
public class 非连续自增 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int maxLength = 0;
        int length = 0;
        char maxChar = '0'; //存储上一个数字字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > maxChar && c <= '9') {
                length++;
                maxChar = c;
                maxLength = Math.max(length,maxLength);
            }else if (c >= '0' && c <= '9'){
                length = 1;
                maxChar = c;
            }else {
                // 如果不是数字
                length = 0;
                maxChar = '0';
            }
        }
        System.out.println(maxLength);
    }
}
