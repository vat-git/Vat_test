package twentyfive.feb.twenteyeight;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequesite = {{1, 0}};
        int numCourse = 2;
        new CourseSchedule().canFinish(numCourse, prerequesite);
    }

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> adjascencyList = new HashMap<>();
            int counter = 0;
            while (counter < numCourses) {
                adjascencyList.put(counter, new ArrayList<>());
                counter++;
            }

            for (int[] prerequisite : prerequisites) {

                List<Integer> orDefault = adjascencyList.getOrDefault(prerequisite[0], new ArrayList<Integer>());
                orDefault.add(prerequisite[1]);
            }

            boolean[] isVisited = new boolean[numCourses];
            numCourses--;
            Stack<Integer> objectStack = new Stack<>();
            while (numCourses >= 0) {
                if (isCyclic(objectStack, numCourses, isVisited, adjascencyList)) {
                    return false;
                }
                numCourses--;
            }
            return true;
        }

    private boolean isCyclic(Stack<Integer> stack, int i, boolean[] isVisited, Map<Integer, List<Integer>> adjascncyList) {
        //cycle
        if (stack.contains(i)) {
            return false;
        }

        if (isVisited[i] == true) {
            return true;
        }

        List<Integer> integers = adjascncyList.get(i);
        stack.add(i);
        Queue<Integer> linkedList = new LinkedList<>(integers);



        for (Integer integer : integers) {
            if (isCyclic(stack, integer, isVisited, adjascncyList)) {
                return true;
            }
            isVisited[integer] = true;
        }

//        stack.remove(i);
        stack.pop();
        return false;

    }







}
