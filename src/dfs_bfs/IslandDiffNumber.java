package dfs_bfs;

import java.util.HashSet;

/**
 * 不同岛屿的数量
 * https://leetcode-cn.com/problems/number-of-distinct-islands/
 */
public class IslandDiffNumber {
    private int row, col;

    public int numDistinctIslands(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(sb, grid, i, j, i, j);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(StringBuilder sb, int[][] grid, int r, int c, int originR, int originC) {
        if (!(0 <= r && r < row && 0 <= c && c < col) || grid[r][c] == 0) return;
        sb.append(r - originR).append(c - originC);
        grid[r][c] = 0;
        dfs(sb, grid, r + 1, c, originR, originC);
        dfs(sb, grid, r - 1, c, originR, originC);
        dfs(sb, grid, r, c + 1, originR, originC);
        dfs(sb, grid, r, c - 1, originR, originC);
    }
}
