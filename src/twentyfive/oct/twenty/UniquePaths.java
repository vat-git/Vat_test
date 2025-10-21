package twentyfive.oct.twenty;

public class UniquePaths {
    public int uniquePathsIII(int[][] grid) {

        int startX = 0;
        int startY = 0;
        int totalEmpty = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int current = grid[i][j];
                if (current == 1) {
                    startX = i;
                    startY = j;
                } else if (current == 0) {
                    totalEmpty++;
                }

            }
        }
        return dfs(startX, startY, grid, totalEmpty + 1);


    }

    private int dfs(int x, int y, int[][] grid, int remaining) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return remaining == 0 ? 1 : 0;
        }

        int temp = grid[x][y];
        grid[x][y] = -1;

        int count = 0;
        count += dfs(x + 1, y, grid, remaining - 1);
        count += dfs(x - 1, y, grid, remaining - 1);
        count += dfs(x, y + 1, grid, remaining - 1);
        count += dfs(x, y - 1, grid, remaining - 1);
        grid[x][y] = temp;
        return count;

    }
}