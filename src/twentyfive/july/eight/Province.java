package twentyfive.july.eight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Province {

  public static void main(String[] args) {
    int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    findCircleNum(matrix);
  }
  public static int findCircleNum(int[][] isConnected) {

    int length = isConnected.length;

    Map<Integer, Set<Integer>> adjascncyList = new HashMap<>();
    for (int i = 0; i < length; i++) {
      adjascncyList.put(i, new HashSet<>());
    }

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {

        if (isConnected[i][j] == 1 && i!=j) {
          adjascncyList.get(i).add(j);
          adjascncyList.get(j).add(i);
        }
      }
    }

    boolean[] isVisisted = new boolean[length];
    Stack<Integer> stack = new Stack<>();

    int provinceCount = 0;

    for (int i = 0; i < length; i++) {
      if(!isVisisted[i]){
        provinceCount++;

      }
        dfs(adjascncyList, i, stack, isVisisted);
    }
    return provinceCount;

  }

  private static void dfs(Map<Integer, Set<Integer>> adjascncyList, int i, Stack<Integer> stack, boolean[] isVisisted) {

    if (stack.contains(i) || isVisisted[i]) {
      return;
    }
    stack.add(i);
    for (Integer integer : adjascncyList.get(i)) {
      dfs(adjascncyList,integer,stack,isVisisted);
    }
    stack.pop();
    isVisisted[i] = true;
  }

}
