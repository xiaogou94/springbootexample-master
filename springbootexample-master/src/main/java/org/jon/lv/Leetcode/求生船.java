package org.jon.lv.Leetcode;

import java.util.Arrays;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/29 21:55
 * @Description:
 */
public class 求生船 {
    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;
        System.out.println(numRescueBoats(people,limit));
    }

    public static int numRescueBoats(int[] people,int limit) {
        Arrays.sort(people);
        int res = 0;
        int L = 0,R = people.length - 1;
        while (L < R) {
            int sum = people[L] + people[R];
            // 假设L和R两人做一艘船
            if (sum <= limit) {
                L++;
            }
            R--;
            res++;
        }
        return res + (L == R ? 1 : 0);
    }
}

