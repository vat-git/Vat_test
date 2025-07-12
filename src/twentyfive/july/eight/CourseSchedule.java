package twentyfive.july.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule {


  public boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> adjascencyList = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      adjascencyList.put(i, new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      adjascencyList.get(prerequisite[0]).add(prerequisite[1]);
    }

    boolean[] isVisited = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < numCourses; i++) {
      if (isCircular(i, isVisited, adjascencyList, stack)) {
        return false;
      }
    }
    return true;

  }

  private boolean isCircular(int i, boolean[] isVisited, Map<Integer, List<Integer>> adjascencyList,
      Stack<Integer> stack) {
    if (isVisited[i] == true) {
      return false;
    }

    if (stack.contains(i)) {
      return true;
    }
    stack.add(i);
    for (Integer integer : adjascencyList.get(i)) {
      if (isCircular(integer, isVisited, adjascencyList, stack)) {
        return true;
      }
    }
    stack.pop();
    isVisited[i] = true;
    return false;
  }


}
