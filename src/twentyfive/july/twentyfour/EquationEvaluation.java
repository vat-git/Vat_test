package twentyfive.july.twentyfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EquationEvaluation {


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

    Map<String,Map<String, Double>> graph = new HashMap();

    for (int i = 0; i < equations.size(); i++) {
      List<String> currentEquation = equations.get(i);
      Double currentValue = values[i];

      String A = currentEquation.get(0);
      String B = currentEquation.get(1);

      graph.computeIfAbsent(A, k -> new HashMap<>()).put(B, currentValue);
      graph.computeIfAbsent(B, k -> new HashMap<>()).put(A, 1 / currentValue);
    }

    double[] results = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {

      List<String> strings = queries.get(i);
      String starting = strings.get(0);
      String ending = strings.get(1);
      if (!graph.containsKey(starting)) {
        results[i] = -1.0;
        continue;
      }

      if (starting.equals(ending)) {
        results[i] = 1.0;
        continue;
      }


      List<String> shortestPath = findShortestPath(graph, starting, ending);
      Double calculatedPathPrice = clacualtePathPrice(graph, shortestPath);
      results[i] = calculatedPathPrice;
    }
    return results;
  }

  private static Double clacualtePathPrice(Map<String, Map<String, Double>> graph, List<String> shortestPath) {
    if (shortestPath == null || shortestPath.isEmpty()) {
      return -1.0;
    }

    double result = 1.0;
    Map<String, Double> currentMap = null;
    for (String s : shortestPath) {
      if (currentMap == null) {
        currentMap = graph.get(s);
      }else{
        result = currentMap.get(s) * result;
        currentMap = graph.get(s);
      }
    }
    return result;
  }

  private static List<String> findShortestPath(Map<String, Map<String, Double>> graph, String starting, String ending) {

    Queue<List<String>> queue = new LinkedList<>();
    List<String> initialPath = new ArrayList<>();
    initialPath.add(starting);
    queue.add(initialPath);

    Set<String> visited = new HashSet<>();
    visited.add(starting);

    while (!queue.isEmpty()) {
      List<String> poll = queue.poll();
      String currentNode = poll.get(poll.size() - 1);
      Map<String, Double> neighbors = graph.get(currentNode);
      for (String neighbor : neighbors.keySet()) {
        if (!visited.contains(neighbor)) {
          visited.add(currentNode);
          List<String> newPath = new ArrayList<>(poll);
          newPath.add(neighbor);
          if (neighbor.equals(ending)) {
            return newPath;
          }
          queue.add(newPath);
        }
      }
    }
    return new ArrayList<>();
  }

}
