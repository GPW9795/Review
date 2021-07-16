package backtracking;

import java.util.*;

/**
 * 子集2
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubSet2 {
    public List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        len = nums.length;
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int begin) {
        res.add(new ArrayList<>(list));
        for (int i = begin; i < len; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
