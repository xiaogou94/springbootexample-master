package org.jon.lv.Leetcode;

import java.util.Arrays;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/19 22:11
 * @Description:
 */
public class 救生艇 {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people,int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length - 1;
        while (light < heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++light;
            ++ans;
        }
        return ans;
    }
}
