package december.eight;

import java.util.*;

public class ECommerseSubset {


    public static void main(String[] args) {
        int[] inout = {120, 200, 150, 90};
        minDifference(inout,250);
    }

    public static List<Integer> minDifference(int[] costs, int budget) {

        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());

        for (int cost : costs) {
            for (int j = budget; j >= cost; j--) {
                System.out.println(j);
                if (dp.containsKey(j)) {
                    continue;
                }
                if (dp.containsKey(j - cost)) {
                    ArrayList<Integer> integers = new ArrayList<>(dp.get(j - cost));
                    integers.add(cost);
                    dp.put(j, integers);
                }
            }
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(cost);
                dp.put(cost, objects);
        }

        for (int i = budget; i >= 0; i--) {
            if (dp.containsKey(i)) {
                return dp.get(i);
            }
        }


        return null;
    }
}
