package backtracking;

import java.util.*;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();
    private int len;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        len = nums.length;
        visited = new boolean[len];
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int depth) {
        if (depth == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
