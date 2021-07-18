package dfs_bfs;

/**
 * 岛屿周长
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class IslandLength {
    private int row, col;

    public int islandPerimeter(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!(0 <= i && i < row && 0 <= j && j < col)) return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }
}
