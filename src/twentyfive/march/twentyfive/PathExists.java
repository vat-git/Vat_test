package twentyfive.march.twentyfive;


import java.util.*;

public class PathExists {
    public static void main(String[] args) {
        int[][] array = {{0, 1}, {1, 2}, {2, 0}};
        LinkedList<Character> test = new LinkedList<>();
        test.push('C');
        test.push('D');

        for (Character c : test) {
            System.out.println(c);
        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjascenyList = new HashMap<>();

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            List<Integer> orDefault = adjascenyList.getOrDefault(i, new ArrayList<>());
            orDefault.add(j);
            adjascenyList.put(i, orDefault);
            List<Integer> jorDefault = adjascenyList.getOrDefault(j, new ArrayList<>());
            jorDefault.add(i);
            adjascenyList.put(j, jorDefault);
        }

            boolean[] isVisisted = new boolean[n];
        if(source==destination){
            return true;
        }
            adjascenyList.get(source);
            if (adjascenyList.isEmpty()) {
                return false;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (!isVisisted[poll]) {
                    isVisisted[poll] = true;
                    List<Integer> integers = adjascenyList.get(poll);
                    for (Integer integer : integers) {
                        if (integer == destination) {
                            return true;
                        }
                        queue.offer(integer);
                    }
                }
        }
        return false;
    }
}
