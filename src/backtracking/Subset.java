package backtracking;

import java.util.*;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subset {
    private int len;
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        len = nums.length;
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int begin) {
        res.add(new ArrayList<>(list));
        for (int i = begin; i < len; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
