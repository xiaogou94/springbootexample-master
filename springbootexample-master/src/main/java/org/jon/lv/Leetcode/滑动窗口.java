package org.jon.lv.Leetcode;

import java.util.Scanner;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/11 21:45
 * @Description: 使用双指针来实现
 */
public class 滑动窗口 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        scanner.nextLine();
//        String[] s = scanner.nextLine().split(" ");
//        for (int i = 0; i < s.length; i++) {
//            nums[i] = Integer.parseInt(s[i]);
//        }
//        int k = scanner.nextInt();
//        int res = 0;
//
//        //双指针
//        int left = 0;
//        int sum = 0;
//        for (int right = 0; right < n; right++) {
//            sum += nums[right];
//            while (left < right && right - left + 1 >= k) {
//                res = Math.max(res,sum);
//                sum -= nums[left++];
//            }
//        }
//        System.out.println(res);
       // 滑动窗口
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        scanner.nextLine();
        String[] strings = scanner.nextLine().split(" ");
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int k = scanner.nextInt();

        int res = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (left < right && right - left + 1 >= k) {
                res = Math.max(res,sum);
                sum -= nums[left--];
            }
        }

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        scanner.nextLine();
//        String[] strings = scanner.nextLine().split(" ");
//        for (int i = 0; i < strings.length; i++) {
//            nums[i] = Integer.parseInt(strings[i]);
//        }
//        int k = scanner.nextInt();
//
//        int res = 0; //取最大的值
//        int left = 0;
//        int sum = 0; // 数组的和
//
//        for (int right = 0; right < n; right++) {
//            sum += nums[right];
//            while (left < right && right - left + 1 >= k) {
//                res = Math.max(res,sum);
//                sum -= nums[left++];
//            }
//        }
//
//        System.out.println(res);













    }
}
