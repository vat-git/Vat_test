package twentyfive.oct.seventeenth;

import java.util.*;

public class CourseSchedule {


    public static void main(String[] args) {
        int[][] input = {{1, 0}};
        canFinish(2, input);
    }

        public static boolean canFinish(int numCourses, int[][] prerequisites) {

            if (prerequisites == null || prerequisites.length== 0) {
                return true;
            }

            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int[] indegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int depedency = prerequisite[1];
                adjList.get(depedency).add(course);
                indegree[course]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            int courseCompletedCount = 0;
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    courseCompletedCount++;
                }

            }


            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                List<Integer> integers = adjList.get(poll);
                for (Integer integer : integers) {
                    indegree[integer]--;
                    if (indegree[integer]==0) {
                        courseCompletedCount++;
                        queue.add(integer);
                    }
                }
            }
            return numCourses == courseCompletedCount;
        }




}
