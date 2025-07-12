package twentyfive.april.second;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] pre = {{1, 0},{0,1}};
        canFinish(2, pre);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {


        if (numCourses < 1) {
            return true;
        }

        Map<Integer, List<Integer>> listMap = new HashMap<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            listMap.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dep = prerequisite[1];
            listMap.get(course).add(dep);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!depthfs(stack, listMap, i,isVisited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean depthfs(Stack<Integer> stack, Map<Integer, List<Integer>> listMap, int i, boolean[] isVisited) {

        if (stack.contains(i)) {
            return false;
        }
        if (isVisited[i]) {
            return true;
        }

        isVisited[i] = true;
        stack.push(i);
        for (Integer integer : listMap.get(i)) {
            if (!depthfs(stack, listMap, integer, isVisited)) {
                return false;
            }
        }
        stack.pop();
        return true;
    }

}
