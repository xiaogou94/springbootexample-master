package org.jon.lv.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: xiaogou
 * @Date: 2022/10/21 21:08
 * @Description:
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 */
public class 组合总结 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      int len = candidates.length;
      List<List<Integer>> res = new ArrayList<>();
      if (len == 0) {
          return res;
      }
      Deque<Integer> path = new ArrayDeque<>();
      dfs(candidates,0,len,target,path,res);
      return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param begin 搜索起点
     * @param len  冗余变量，是candidates 里的属性，可以不传
     * @param target 每减去一个元素，目标值变小
     * @param path 从根节点到叶子节点的路劲，是一个栈
     * @param res 结果集
     */
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
       // target为负数和0的时候不再产生新的孩子节点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        // 重点理解这里begin开始搜索的寓意
        for (int i = 0; i < len; i++) {
            path.addLast(candidates[i]);

            dfs(candidates, i, len, target-candidates[i], path, res);

            path.removeLast();
        }
    }
}
