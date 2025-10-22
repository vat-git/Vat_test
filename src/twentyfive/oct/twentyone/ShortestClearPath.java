package twentyfive.oct.twentyone;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestClearPath {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};
        if (grid == null || grid.length == 0) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        boolean[][] isVisited = new boolean[grid.length][grid.length];

        while (!queue.isEmpty()) {


            int[] poll = queue.poll();
            if (poll[0] == grid.length - 1 && poll[1] == grid.length - 1) {
                return poll[2] + 1;
            }
            for (int[] direction : directions) {
                int newX = poll[0]+direction[0];
                int newY = poll[1]+direction[1];
                if(newX >=0 && newX <= grid.length-1&& newY >=0&& newY <= grid.length-1 && grid[newX][newY]!=1 && !isVisited[newX][newY]){
                    isVisited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, poll[2] + 1});
                }
            }

        }

        return -1;


    }
}
