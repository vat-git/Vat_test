package twentyfive.april.second;


import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        findOrder(2, pre);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {


        if (numCourses < 1) {
            return new int[0];
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
        List<Integer> visitedOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!depthfs(stack, listMap, i,isVisited,visitedOrder)) {
                return new int[0];
            }
        }
        return visitedOrder.stream().mapToInt(i->i).toArray();
    }

    private static boolean depthfs(Stack<Integer> stack, Map<Integer, List<Integer>> listMap, int i, boolean[] isVisited,List<Integer> visitedOrder) {

        if (stack.contains(i)) {
            return false;
        }
        if (isVisited[i]) {
            return true;
        }

        isVisited[i] = true;
        stack.push(i);
        for (Integer integer : listMap.get(i)) {
            if (!depthfs(stack, listMap, integer, isVisited,visitedOrder)) {
                return false;
            }
        }
        visitedOrder.add(i);
        stack.pop();
        return true;
    }

}
