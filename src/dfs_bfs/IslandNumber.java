package dfs_bfs;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class IslandNumber {
    private int row;
    private int col;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
