package twentyfive.oct.twentytwo;

import java.util.*;

public class NetwrokDelay {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair>> adjList = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int timeTake = time[2];
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(new Pair(timeTake, dest));
        }

        int[] signalReceivedAt = new int[n+1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        dijks(signalReceivedAt, k, n,adjList);
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    private void dijks(int[] signalReceivedAt, int k, int n, Map<Integer, List<Pair>> adjList) {
        Queue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(p -> p.first)
        );

        pq.add(new Pair(0, k));

        signalReceivedAt[k] = 0;

        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            int currentNode = poll.second;
            int currentNodeTime = poll.first;

            if (signalReceivedAt[currentNode] < currentNodeTime) {
                continue;
            }
            if (!adjList.containsKey(currentNode)) {
                continue;
            }

            for (Pair pair : adjList.get(currentNode)) {
                int neighbor = pair.second;
                int neighborTimeTaken = pair.first;
                if(signalReceivedAt[neighbor]>currentNodeTime+neighborTimeTaken){
                    signalReceivedAt[neighbor] = currentNodeTime + neighborTimeTaken;
                    pq.add(new Pair(neighborTimeTaken + currentNodeTime, neighbor));
                }


            }
        }

    }

    public class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
