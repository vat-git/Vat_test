package twentyfive.july.twentyseven;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int price = flight[2];

      Map<Integer, Integer> orDefault = graph.getOrDefault(from, new HashMap<>());
      orDefault.put(to, price);
      graph.put(from, orDefault);
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    priorityQueue.add(new int[]{0, src, 0});

    int[][] dist = new int[n][k+2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[src][0] = 0;

    int minprice = Integer.MAX_VALUE;
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int currentCost = poll[0];
      int currentCity = poll[1];
      int stopCount = poll[2];

      if (currentCost > dist[currentCity][stopCount] || stopCount > k+1) {
        continue;
      }
      if (currentCity==dst) {
        minprice = Math.min(currentCost, minprice);
      }
      if (stopCount > k) {
        continue;
      }
        if (graph.containsKey(currentCity)) {
          for (Entry<Integer, Integer> integerIntegerEntry : graph.get(currentCity).entrySet()) {

            Integer neighbor = integerIntegerEntry.getKey();
            Integer neighborPrice = integerIntegerEntry.getValue();
            int currentPrice = neighborPrice + currentCost;
            int newStopCount = stopCount + 1;
            if (dist[neighbor][newStopCount] > currentPrice) {
              dist[neighbor][newStopCount] = currentPrice;
              priorityQueue.add(new int[]{currentPrice, neighbor, newStopCount});
            }
          }
        }
      }
    if (minprice != Integer.MAX_VALUE) {
      return minprice;
    }
    return -1;
  }


}
