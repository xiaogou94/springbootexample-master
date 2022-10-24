package org.jon.lv.Leetcode;

import java.util.Arrays;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/19 22:35
 * @Description:
 */
public class 最短无序的连续子数组 {
    public static void main(String[] args) {
       int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] numsSort = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numsSort);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right && nums[left] == numsSort[left]) {
            left++;
        }
        while (left < right && nums[right] == numsSort[right]) {
            right--;
        }
        return right - left + 1;
    }
}
