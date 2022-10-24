package org.jon.lv.Leetcode;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/23 15:39
 * @Description:
 * x = -123
 * 输出：-321
 */
public class 整数反转 {
    public static void main(String[] args) {
        reverse(120);
    }

    public static int reverse(int x) {
        int num = 0;
        while (x!=0) {
            int temp = x % 10;
            num = num * 10 + temp;
            x = x / 10;
        }
        return num;
    }
}
