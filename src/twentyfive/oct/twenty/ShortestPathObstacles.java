package twentyfive.oct.twenty;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathObstacles {
    public int shortestPath(int[][] grid, int k) {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int width = grid[0].length;
        int height = grid.length;
        if (height == 1 && width == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, k});
        boolean isVisited[][][] = new boolean[height][width][k + 1];

        isVisited[0][0][k] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] direction : directions) {
                int newX = poll[0] + direction[0];
                int newY = poll[1] + direction[1];

                if (newX < 0 || newY < 0 || newX >= height || newY >= width) {
                    continue;
                }

                if (newX == height - 1 && newY == width - 1) {
                    return poll[2] + 1;
                }

                int remaning = poll[3];
                if (grid[newX][newY] == 1) {
                    if (remaning > 0) {
                        remaning--;
                    }else{
                        continue;
                    }
                }

                if (!isVisited[newX][newY][remaning]) {
                    isVisited[newX][newY][remaning] = true;
                    queue.offer(new int[]{newX, newY, poll[2] + 1, remaning});
                }
            }
        }
        return -1;
    }
}

