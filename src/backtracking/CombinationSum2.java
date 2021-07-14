package backtracking;

import java.util.*;

/**
 * 组合总和2
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();
    public int len;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        len = candidates.length;
        Arrays.sort(candidates);
        sum(candidates, 0, 0, target);
        return res;
    }

    private void sum(int[] candidates, int begin, int sum, int target) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = begin; i < len; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= target - sum) {
                list.add(candidates[i]);
                sum += candidates[i];
                sum(candidates, i + 1, sum, target);
                sum -= list.remove(list.size() - 1);
            }
        }
    }
}
