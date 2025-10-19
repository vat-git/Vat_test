package twentyfive.oct.eighteenth;

import java.util.*;

public class MHT {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Collections.singletonList(0);
        }

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            adjList.get(source).add(dest);
            adjList.get(dest).add(source);
            indegree[source]++;
            indegree[dest]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <n; i++) {
            if (indegree[i]==1) {
                queue.add(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {

            int size = queue.size();
            remaining = remaining - size;
            for (int i = 0; i <size; i++) {
                Integer polled = queue.poll();
                for (Integer integer : adjList.get(polled)) {
                    indegree[integer]--;
                    if (indegree[integer] == 1) {
                        queue.add(integer);
                    }
                }
            }
        }
        return queue.stream().toList();
    }

}
