package twentyfive.oct.twentyfive;

import java.util.*;

public class CitiesShortestPath {



        public int minCost(int maxTime, int[][] edges, int[] passingFees) {

            Map<Integer, List<Distance>> adjMap = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {

                int source = edges[i][0];
                int dest = edges[i][1];
                int weight = edges[i][2];
                adjMap.putIfAbsent(source, new ArrayList<>());
                adjMap.putIfAbsent(dest, new ArrayList<>());

                adjMap.get(source).add(new Distance(dest, weight));
                adjMap.get(dest).add(new Distance(source, weight));
            }

            int[] minTime = new int[passingFees.length];

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            Arrays.fill(minTime,Integer.MAX_VALUE);

            minTime[0] = 0;

            priorityQueue.add(new int[]{passingFees[0], 0, 0});

            while (!priorityQueue.isEmpty()) {

                int[] poll = priorityQueue.poll();
                int fee = poll[0];
                int node = poll[1];
                int weight = poll[2];

                if (node == passingFees.length - 1) {
                    return fee;
                }
                if (adjMap.containsKey(node)) {
                    for (Distance distance : adjMap.get(node)) {
                        int neighbor = distance.node;
                        int neighWeight = distance.weight;
                        int neighCost = passingFees[neighbor];

                        int newWeight = neighWeight + weight;
                        int newCost = neighCost + fee;

                        if (newWeight > maxTime) {
                            continue;
                        }
                        if (newWeight < minTime[neighbor]) {
                            minTime[neighbor] = newWeight;
                            priorityQueue.offer(new int[]{newCost, neighbor, newWeight});
                        }


                    }
                }

            }
            return -1;




        }

        class Distance{
            int node;
            int weight;

            public Distance(int node, int weight) {
                this.node = node;
                this.weight = weight;

            }
        }

}
