package twentyfive.june.twelve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {

        if (x == y) {
            return 1;
        }
        Map<Integer, ArrayList<Integer>> adjascencyMap = new HashMap<>();
        for (ArrayList<Integer> integers : adj) {
            Integer from = integers.get(0);
            Integer to = integers.get(1);

          if (!adjascencyMap.containsKey(from)) {
              adjascencyMap.put(from, new ArrayList<>());
          }
            adjascencyMap.get(from).add(to);
        }

        if (adjascencyMap.containsKey(x)) {
            ArrayList<Integer> start = adjascencyMap.get(x);
            Stack<Integer> stack = new Stack<>();
            boolean[] isVisited = new boolean[adjascencyMap.keySet().size()];
            stack.add(x);
            if (start != null && !start.isEmpty()) {
                for (Integer i : start) {
                  if (dfs(stack, isVisited, adjascencyMap, i, y)) {
                      return 1;
                  }
                }
            }
        }
        return 0;

    }

    private static boolean dfs(Stack<Integer> stack, boolean[] isVisited, Map<Integer, ArrayList<Integer>> adjascencyMap, int currentElement,
        Integer target) {
        if (currentElement == target) {
            return true;
        }
      if (isVisited[currentElement]==true) {
          return false;
      }

        if (stack.contains(currentElement)) {
            return false;
        }
        ArrayList<Integer> integers = adjascencyMap.get(currentElement);
        stack.add(currentElement);
        isVisited[currentElement] = true;
        if(integers!=null) {
            for (Integer integer : integers) {
                if (dfs(stack, isVisited, adjascencyMap, integer, target)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

