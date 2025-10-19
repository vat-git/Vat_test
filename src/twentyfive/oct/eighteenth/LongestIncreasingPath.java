package twentyfive.oct.eighteenth;

public class LongestIncreasingPath {

    /**
     * graph edges can be formed dynamically -> four directions after validation
     * track isVisited
     *
     *
     * @param matrix
     * @return
     */

    public int longestIncreasingPath(int[][] matrix) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, directions, dp,i,j));
            }
        }
        return max;
        }

    private int dfs(int[][] matrix, int[][] directions, int[][] dp, int i, int j) {

        if (dp[i][j]!=0) {
            return dp[i][j];
        }
        int max = 1;

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                max = Math.max(max, 1 + dfs(matrix, directions, dp, x, y));
            }
        }
        dp[i][j] = max;
        return max;

    }
}
