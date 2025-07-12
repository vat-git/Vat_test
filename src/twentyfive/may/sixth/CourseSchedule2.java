package twentyfive.may.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule2 {

  public static void main(String[] args) {
    int[][] pre = {{1, 0}};
    findOrder (2, pre);
  }
  public static int[] findOrder(int numCourses, int[][] prerequisites)  {

    if (numCourses < 1) {
      return null;
    }

    Map<Integer, List<Integer>> adLi = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      adLi.put(i, new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      adLi.get(prerequisite[0]).add(prerequisite[1]);
    }

    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[numCourses];
    Queue<Integer> order = new LinkedList<>();
    for (Integer i : adLi.keySet()) {
      if(isCyclic(adLi, i, visited, stack, order)) {
        return new int[0];
      }
    }
    int[] result = new int[numCourses];
    int counter = 0;
    while (!order.isEmpty()) {
      result[counter] = order.poll();
      counter++;
    }
    return result;

  }

  private static boolean isCyclic(Map<Integer, List<Integer>> adLi, Integer i, boolean[] visited,
      Stack<Integer> stack, Queue<Integer> queue) {
    if (stack.contains(i)) {
      return true;
    }
    if (visited[i]) {
      return false;
    }

    List<Integer> integers = adLi.get(i);
    stack.add(i);
    visited[i] = true;
    for (Integer integer : integers) {
      if (isCyclic(adLi, integer, visited, stack, queue)) {
        return true;
      }
    }
    queue.add(stack.pop());
    return false;
  }

}
