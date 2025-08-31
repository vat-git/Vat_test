package twentyfive.july.seventeen;

public class LongestIncreasingPath {


  public static void main(String[] args) {
    int[][] matrix = {
        {3, 4, 5},
        {3, 2, 6},
        {2, 2, 1}
    };

    System.out.println(longestIncreasingPath(matrix));
  }

  public static int longestIncreasingPath(int[][] matrix) {

    int[][] dp = new int[matrix.length][matrix[0].length];
    int[][] manipulation = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    int longestPath = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int result = longestPathCount(matrix, dp, i, j,manipulation);

        if (result>longestPath) {
          longestPath = result;
        }

      }

    }
    return longestPath;
  }

  private static int longestPathCount(int[][] matrix, int[][] dp, int i, int j,
      int[][] manipulation) {

    if (dp[i][j]!=0) {
      return dp[i][j];
    }

    int currentLongest = 1;
    for (int[] ints : manipulation) {

      int newI = i + ints[0];
      int newJ = j + ints[1];

      if (newI>=0&&newI< matrix.length&&newJ>=0&&newJ<matrix[i].length&&matrix[newI][newJ]>matrix[i][j]) {
        currentLongest = Math.max(currentLongest,1+ longestPathCount(matrix, dp, newI, newJ, manipulation));
      }

    }
    dp[i][j] = currentLongest;
    return currentLongest;


  }


}
