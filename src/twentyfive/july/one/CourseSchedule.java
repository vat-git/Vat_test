package twentyfive.july.one;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites){

    Map<Integer, List<Integer>> adjasencyList = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      adjasencyList.put(i, new ArrayList<>());

    }

    for (int[] prerequisite : prerequisites) {
      adjasencyList.get(prerequisite[0]).add(prerequisite[1]);
    }

    boolean[] isVisited = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < numCourses; i++) {
      if (isCyclic(adjasencyList, stack, isVisited,i)) {
        return false;
      }
    }
    return true;



  }

  private boolean isCyclic(Map<Integer, List<Integer>> adjasencyList, Stack<Integer> stack,
      boolean[] isVisited, int current) {

    if (stack.contains(current)) {
      return true;
    }

    if (isVisited[current]) {
      return false;
    }

    stack.add(current);
    for (Integer nextInt : adjasencyList.get(current)) {
      if (isCyclic(adjasencyList, stack, isVisited, nextInt)) {
        return true;
      }
    }
    stack.pop();
    isVisited[current] = true;
    return false;

  }


}
