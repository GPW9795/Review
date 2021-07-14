package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();
    private int len;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
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
            if (candidates[i] <= target - sum) {
                list.add(candidates[i]);
                sum += candidates[i];
                sum(candidates, i, sum, target);
                sum -= list.remove(list.size() - 1);
            }
        }
    }
}
