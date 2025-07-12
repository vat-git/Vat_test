package twentyfive.june.one;

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
    Stack<Integer> currentStack = new Stack<>();
    boolean[] isVisited = new boolean[numCourses];
    for (Integer i : adjascencyList.keySet()) {
      if (isCyclic(i, isVisited, adjascencyList,currentStack)) {
        return false;
      }
    }
    return true;
  }


  private boolean isCyclic(Integer i, boolean[] isVisited,
      Map<Integer, List<Integer>> adjascencyList, Stack<Integer> currentStack){
    if (currentStack.contains(i)) {
      return true;
    }

    if (isVisited[i]==true) {
      return false;
    }

    currentStack.add(i);
    for (Integer integer : adjascencyList.get(i)) {
      if (isCyclic(integer, isVisited, adjascencyList, currentStack)) {
        return true;
      }
    }
    currentStack.pop();
    isVisited[i] = true;
    return false;
  }

  }
