package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Permutations2 {
    public List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int len;
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        len = nums.length;
        visited = new boolean[len];
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int depth) {
        if (depth == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, depth + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
