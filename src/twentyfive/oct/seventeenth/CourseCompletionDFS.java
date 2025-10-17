package twentyfive.oct.seventeenth;

import java.util.*;

public class CourseCompletionDFS {
    public static void main(String[] args) {
        int[][] input = {{1, 0}};
        canFinish(2, input);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dep = prerequisite[1];
            adjList.get(course).add(dep);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                if (cyclic(stack, isVisited, adjList, i)) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean cyclic(Stack<Integer> stack, boolean[] isVisited, Map<Integer, List<Integer>> adjList, int i) {

        if (stack.contains(i)) {
            return true;
        }

        if(isVisited[i]){
            return false;
        }

        stack.add(i);
        for (Integer integer : adjList.get(i)) {
            if (cyclic(stack, isVisited, adjList, integer)) {
                return true;
            }
        }
        stack.pop();
        isVisited[i] = true;
        return false;

    }


}
