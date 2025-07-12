package twentyfive.may.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule {

  public static void main(String[] args) {
    int[][] pre = {{0, 1},{0,2},{1,3},{2,3}};
    canFinish(4, pre);
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    if (numCourses < 1) {
      return true;
    }

    Map<Integer, List<Integer>> adjascencyList = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      adjascencyList.put(i, new ArrayList<>());

    }


    for (int[] prerequisite : prerequisites) {
      int course = prerequisite[0];
      int dependency = prerequisite[1];
      adjascencyList.get(course).add(dependency);
    }

    boolean[] isVisited = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();

    for (Integer i : adjascencyList.keySet()) {
      if (isCyclic(adjascencyList, i, isVisited, stack)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isCyclic(Map<Integer, List<Integer>> adjascencyList, Integer i, boolean[] isVisited, Stack<Integer> stack) {

    if (stack.contains(i)) {
      return true;
    }

    if (isVisited[i]) {
      return false;
    }

    List<Integer> integers = adjascencyList.get(i);
    stack.add(i);
    if (integers != null && integers.size() > 0) {
      for (Integer integer : integers) {
        if (isCyclic(adjascencyList, integer, isVisited, stack)) {
          return true;
        }
      }
    }
    isVisited[i] = true;
    stack.pop();
    return false;

  }


}
