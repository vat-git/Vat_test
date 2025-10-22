    package twentyfive.oct.twentyone;

    import java.util.LinkedList;
    import java.util.Queue;

    public class ShortestPathFood {

        public int getFood(char[][] grid) {
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},};
            int startX = -1;
            int startY = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '*') {
                        startY = j;
                        startX = i;
                    }
                }
            }

            Queue<int[]> queueu = new LinkedList<>();
            queueu.offer(new int[]{startX, startY, 0});
            boolean isVisited[][] = new boolean[grid.length][grid[0].length];


            while (!queueu.isEmpty()) {

                int[] poll = queueu.poll();
                int currentX = poll[0];
                int currentY = poll[1];
                if (grid[currentX][currentY] == '#') {
                    return poll[2];
                }


                isVisited[currentX][currentY] = true;
                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];

                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                        continue;
                    }
                    if (!isVisited[newX][newY] && grid[newX][newY]!='X') {
                        isVisited[newX][newY] = true;
                        queueu.offer(new int[]{newX, newY, poll[2] + 1});
                    }
                }
            }
            return -1;


        }
    }
