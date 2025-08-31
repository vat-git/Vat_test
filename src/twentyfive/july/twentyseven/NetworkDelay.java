package twentyfive.july.twentyseven;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.IntToDoubleFunction;

public class NetworkDelay {

  /**
   * Form the graph
   * use dijkstra's algorithm to find the shortest path in weighted graph
   *
   *
   */

  public static void main(String[] args) {
    int[][] array = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    networkDelayTime(array, 4, 2);
  }

  public static int networkDelayTime(int[][] times, int n, int k) {

    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] time : times) {
      int currentNode = time[0];
      int neighborNode = time[1];
      int neighborWeight = time[2];

      Map<Integer, Integer> orDefault = graph.getOrDefault(currentNode, new HashMap<>());
      orDefault.put(neighborNode, neighborWeight);
      graph.put(currentNode, orDefault);
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    Map<Integer, Integer> distnace = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      distnace.put(i, Integer.MAX_VALUE);
    }

    distnace.put(k, 0);
    priorityQueue.add(new int[]{0, k});

    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int weighttoCurrentNode = poll[0];
      int currentNode = poll[1];
      if (distnace.get(currentNode) <= weighttoCurrentNode) {
        continue;
      }
      if (graph.containsKey(currentNode)) {
        for (Entry<Integer, Integer> integerEntry : graph.get(currentNode).entrySet()) {
          Integer neighbor = integerEntry.getKey();
          int neighborWeight = integerEntry.getValue();
          int weightToNeighbor = weighttoCurrentNode + neighborWeight;
          if (distnace.get(neighbor) > weightToNeighbor) {
            distnace.put(neighbor, weightToNeighbor);
            priorityQueue.add(new int[]{weightToNeighbor, neighbor});
          }
        }
      }
    }

    int maxTime = 0;
    for (int i = 1; i <=n ; i++) {
      if (distnace.get(i) == Integer.MAX_VALUE) {
        return -1;
      }

      if (maxTime < distnace.get(i)) {
        maxTime = distnace.get(i);
      }
    }
    return maxTime;


  }

}
