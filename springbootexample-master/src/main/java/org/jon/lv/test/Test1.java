package org.jon.lv.test;

import java.util.Arrays;

/**
 * @Auther: xiaogou
 * @Date: 2022/07/23 15:22
 * @Description: 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回 承载所有人所需的最小船数 。
 * <p>
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * 提示：
 * 1 <= people[i] <= limit
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 3, 4};
        int limit = 5;
        Arrays.sort(nums);
        System.out.println(getMinNumber(nums, limit));
    }

    public static int getMinNumber(int[] nums, int limit) {
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = 0;
        }
        int length = nums.length;
        int chuanCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums1[i] == 1) {
                continue;
            }
            chuanCount++;
            if (nums[i] == limit) {
                nums1[i] = 1;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums1[j] == 1) {
                    continue;
                }
                if (nums[i] + nums[j] <= limit) {
                    nums1[j] = 1;
                    break;
                }
            }
        }
        return chuanCount;
    }
}
