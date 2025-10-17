package twentyfive.oct.seventeenth;

import java.util.*;

public class CourseScheduleKhans {


        public static void main(String[] args) {
            int[][] input = {{1, 0}};
            canFinish(2, input);
        }

        public static boolean canFinish(int numCourses, int[][] prerequisites) {


            //1. create adj list and indegree map
            Map<Integer, List<Integer>> adjList = new HashMap<>();
            int[] indegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int dep = prerequisite[1];
                adjList.get(dep).add(course);
                indegree[course]++;
            }

            int courseCompleted = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; i++) {
                if (indegree[i]==0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                courseCompleted++;
                List<Integer> integers = adjList.get(poll);
                for (Integer integer : integers) {
                    indegree[integer]--;
                    if (indegree[integer]==0) {
                        queue.add(integer);
                    }
                }
            }
            return courseCompleted == numCourses;
            }




        }
