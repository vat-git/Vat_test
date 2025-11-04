package twentyfive.nov;

import java.util.Stack;

public class MinIslands {

    public int numIslands(char[][] grid) {

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {
                0, -1}};

        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!isVisited[i][j] && grid[i][j]=='1') {
                    dfs(i, j, isVisited, grid, directions);
                    answer++;
                }
            }

        }
        return answer;

    }

    private void dfs(int i, int j, boolean[][] isVisited, char[][] grid, int[][] directions) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (isVisited[i][j] || grid[i][j] == '0') {
                return;
            }

            isVisited[i][j] = true;

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];


                dfs(x, y, isVisited, grid, directions);

            }


        }
    }

}
