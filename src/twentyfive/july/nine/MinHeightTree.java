package twentyfive.july.nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinHeightTree {

  public static void main(String[] args) {
    int[][] test = {{0, 1}, {0, 2}};
    findMinHeightTrees(3, test);
  }

  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {


    if (n == 1) {
      return Collections.singletonList(0);
    }
    Map<Integer, List<Integer>> adjascencyList = new HashMap<>();
    for (int i = 0; i < n; i++) {
      adjascencyList.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjascencyList.get(edge[0]).add(edge[1]);
      adjascencyList.get(edge[1]).add(edge[0]);
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (adjascencyList.get(i).size() == 1) {
        queue.add(i);
      }
    }

    int remainingNodeCount = n;

    while (remainingNodeCount > 2) {
      int currentLeavesCount = queue.size();
      remainingNodeCount = remainingNodeCount - currentLeavesCount;
      for (int i = 0; i < currentLeavesCount; i++) {

        Integer polled = queue.poll();
        Integer neighbor = adjascencyList.get(polled).get(0);
        adjascencyList.get(neighbor).remove(polled);
        if (adjascencyList.get(neighbor).size() == 1) {
          queue.add(neighbor);
        }
      }
    }
    return new ArrayList<>(queue);

  }

}
