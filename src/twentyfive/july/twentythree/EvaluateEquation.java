package twentyfive.july.twentythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class EvaluateEquation {

  /**
   * 1. build the graph in forward and reverse way
   * 2. find shortest path
   * 3. calculate weight
   */

  public static void main(String[] args) {
    List<List<String>> equations = new ArrayList<>();
    equations.add(Arrays.asList("a", "b"));
    equations.add(Arrays.asList("b", "c"));

    // values = [2.0, 3.0]
    double[] values = {2.0, 3.0};

    // queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    List<List<String>> queries = new ArrayList<>();
    queries.add(Arrays.asList("a", "c"));
    queries.add(Arrays.asList("b", "a"));
    queries.add(Arrays.asList("a", "e"));
    queries.add(Arrays.asList("a", "a"));
    queries.add(Arrays.asList("x", "x"));

    calcEquation(equations, values, queries);
  }

  public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String A = equations.get(i).get(0);
      String B = equations.get(i).get(1);
      double val = values[i];

      // Add A -> B edge: A / B = val
      // computeIfAbsent is a concise way to get the inner map or create it if it doesn't exist
      graph.computeIfAbsent(A, k -> new HashMap<>()).put(B, val);

      // Add B -> A (reciprocal) edge: B / A = 1 / val
      graph.computeIfAbsent(B, k -> new HashMap<>()).put(A, 1.0 / val);
    }

    double[] results = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String starting = query.get(0);
      String ending = query.get(1);

      if (!graph.containsKey(starting)) {
        results[i] = -1;
        continue;
      }
      if (starting.equals(ending)) {
        results[i] = 1;
        continue;
      }



      List<String> bfsPath = bfs(graph, starting, ending);
      if (bfsPath.isEmpty()) {
        results[i] = -1.0;
      }else {
        double value = calculateValue(graph, bfsPath);
        results[i] = value;
      }
    }
    return results;
  }

  private static double calculateValue(Map<String, Map<String, Double>> graph, List<String> bfsPath) {
    double result = 1.0;

    Map<String, Double> currentMap = null;

    for (String node : bfsPath) {
      if (currentMap == null) {
        currentMap = graph.get(node);
      } else {
        result = result * currentMap.get(node);
        currentMap = graph.get(node);
      }
    }
    return result;
  }

  private static List<String> bfs(Map<String, Map<String, Double>> graph, String starting, String ending) {

    Queue<List<String>> queue = new LinkedList<>();
    List<String> path = new ArrayList<>();
    Set<String> isVisited = new HashSet<>();

    path.add(starting);
    queue.add(path);
    isVisited.add(starting);

    while (!queue.isEmpty()) {
      List<String> poll = queue.poll();
      String currentNode = poll.get(poll.size() - 1);

      if (currentNode.equals(ending)) {
        return poll;
      }

      if (graph.containsKey(currentNode)) {
        for (Entry<String, Double> stringDoubleEntry : graph.get(currentNode).entrySet()) {
          String key = stringDoubleEntry.getKey();
          if (!isVisited.contains(key)) {
            isVisited.add(key);
            List<String> newPath = new ArrayList<>(poll);
            newPath.add(key);
            queue.add(newPath);
          }
        }
      }
    }

    return Collections.emptyList();
  }

}
