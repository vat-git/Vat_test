package twentyfive.may.ninth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule {
  public int[] findOrder(int numCourses, int[][] prerequisites){

    Map<Integer, List<Integer>> adjasencyList = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      adjasencyList.put(i, new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      adjasencyList.get(prerequisite[0]).add(prerequisite[1]);
    }

    boolean[] isVisited = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();
    List<Integer> order = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
       if(isCyclic(stack,i,adjasencyList,isVisited,order)){
         return new int[0];
       }
    }
    return order.stream().mapToInt(Integer::intValue).toArray();
  }

  private boolean isCyclic(Stack<Integer> stack, int i, Map<Integer, List<Integer>> adjasencyList,
      boolean[] isVisited, List<Integer> order) {
    if (stack.contains(i)) {
      return true;
    }
    if (isVisited[i] == true) {
      return false;
    }

    stack.add(i);

    List<Integer> list = adjasencyList.get(i);
    for (Integer integer : list) {
      if (isCyclic(stack, integer, adjasencyList, isVisited, order)) {
        return true;
      }
    }
    isVisited[i] = true;
    order.add(stack.pop());
    return false;
  }


}
