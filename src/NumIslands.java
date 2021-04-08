/*
Use DFS
Use that there are only 2 states for the island
*/

public class NumIslands {
    public int numIslands(char[][] grid) {
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                res += dfs(i, j, grid);

            }
        }

        return res;
        
    }

    public int dfs(int i, int j, char[][] grid) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);

        return 1;

    }

    public static void main(String[] args) {
        
    }
}
