package twentyfive.oct.seventeenth;

import java.util.*;

public class CourseOrder {
    public static void main(String[] args) {
        int[][] input = {{1, 0}};
        findOrder(2, input);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length < 1) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];


        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dep = prerequisite[1];
            List<Integer> orDefault = adjList.getOrDefault(dep, new ArrayList<>());
            orDefault.add(course);
            adjList.put(dep, orDefault);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]==0) {
                queue.add(i);
            }
        }


        int courseComplted = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[courseComplted] = poll;
            courseComplted++;
            List<Integer> integers = adjList.get(poll);
            if(integers==null||integers.isEmpty()){
                break;

            }
            for (Integer integer : integers) {
                indegree[integer]--;
                if (indegree[integer]==0) {
                    queue.add(integer);
                }
            }
        }

        if (courseComplted == numCourses) {
            return result;
        }
        return new int[]{};


    }
}