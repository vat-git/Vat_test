package twentyfive.feb;

import java.util.*;

public class CourseSchedule {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> adjascencyList = new HashMap<>();

            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                if (adjascencyList.containsKey(course)) {
                    adjascencyList.get(course).add(preCourse);
                } else {
                    adjascencyList.put(course, new ArrayList<>(Arrays.asList(preCourse)));
                }
            }
            boolean[] visited = new boolean[numCourses];


            return false;
        }
    }



}
