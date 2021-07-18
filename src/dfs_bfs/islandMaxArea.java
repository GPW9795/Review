package dfs_bfs;

/**
 * 岛屿最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class islandMaxArea {
    private int row, col;

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < row && 0 <= c && c < col) || grid[r][c] == 0) return 0;
        int num = 1;
        grid[r][c] = 0;
        num += dfs(grid, r + 1, c);
        num += dfs(grid, r - 1, c);
        num += dfs(grid, r, c + 1);
        num += dfs(grid, r, c - 1);
        return num;
    }
}
