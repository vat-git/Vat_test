package sep;

import java.util.*;

public class FindIfPathExist {


    public static void main(String[] args) {
        int n=3;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int sour = 0;
        int dest = 2;
        validPath(n, edges, sour, dest);

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, ArrayList<Integer>> relations = new HashMap<>();
        //form the relations
        for (int[] edge : edges) {

            relations.putIfAbsent(edge[0], new ArrayList<>());
            relations.putIfAbsent(edge[1], new ArrayList<>());
            relations.getOrDefault(edge[0], new ArrayList<>()).add(edge[1]);
            relations.getOrDefault(edge[1], new ArrayList<>()).add(edge[0]);
        }
        boolean[] isVisited = new boolean[n];
//        boolean result= dfs(source, destination, relations,isVisited);
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            isVisited[poll] = true;
            ArrayList<Integer> integers = relations.get(poll);
            for (Integer integer : integers) {
                if (integer == source) {
                    return true;
                }else{
                    if (isVisited[integer] != true) {
                        queue.add(integer);
                    }
                }
            }
        }
        return false;

    }

    private static boolean dfs(int source, int destination, Map<Integer, ArrayList<Integer>> relations, boolean[] isVisited) {

        if (source == destination) {
            return true;
        }
        isVisited[source] = true;
        ArrayList<Integer> integers = relations.get(source);
        //go to all neighbors and dfs
        for (Integer integer : integers) {
            if (isVisited[integer] != true) {
                boolean dfs = dfs(integer, destination, relations, isVisited);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

}
