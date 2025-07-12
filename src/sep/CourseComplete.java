package sep;

import java.util.*;

public class CourseComplete {

    public static void main(String[] args) {
        int[][] prerequesite = {{1, 0}};
        int numCourse = 2;
        canFinish(numCourse, prerequesite);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses < 1) {
            return true;
        }
        Map<Integer, ArrayList<Integer>> adjascencyList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjascencyList.put(i, new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites) {
            adjascencyList.get(prerequisite[0]).add(prerequisite[1]);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjascencyList, stack, isVisited, i)) {
                return false;
            }
        }
        return true;

    }

    public static boolean dfs(Map<Integer, ArrayList<Integer>> adjascencyList, Stack<Integer> stack, boolean[] isVsited, int i) {

        if (stack.contains(i)) {
            return true;
        }


        if (isVsited[i] == true) {
            return false;
        }


        ArrayList<Integer> integerArrayList = adjascencyList.get(i);
        if (integerArrayList == null || integerArrayList.isEmpty()) {
            return false;
        }

        stack.add(i);
        for (Integer integer : integerArrayList) {
            if (dfs(adjascencyList, stack, isVsited, integer)) {
                return true;
            }
            isVsited[integer] = true;
        }
        stack.remove(i);
        stack.pop();
        return false;

    }
}













//        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??
//
//        // create the array lists to represent the courses
//        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
//        for (int i = 0; i < numCourses; i++) {
//            courses.add(new ArrayList<Integer>());
//        }
//
//        // create the dependency graph
//        for (int i = 0; i < prerequisites.length; i++) {
//            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
//        }
//
//        int[] visited = new int[numCourses];
//
//        // dfs visit each course
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(i, courses, visited)) return false;
//        }
//
//        return true;
//    }
//
//    private static boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
//
//        visited[course] = 1; // mark it being visited
//
//        List<Integer> eligibleCourses = courses.get(course); // get its children
//
//        // dfs its children
//        for (int i = 0; i < eligibleCourses.size(); i++) {
//            int eligibleCourse = eligibleCourses.get(i).intValue();
//
//            if (visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
//            if (visited[eligibleCourse] == 0) { // not visited
//                if (!dfs(eligibleCourse, courses, visited)) return false;
//            }
//
//        }
//
//        visited[course] = 2; // mark it done visiting
//        return true;
//    }
