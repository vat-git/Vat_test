package december.ninteenth;

import java.util.*;

public class RoomSelection {


    private static List<Integer> selectRooms(List<Integer> inputs, int target) {

        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>(Arrays.asList(0)));
        for (Integer input : inputs) {
            for (int i = target; i >= input; i--) {
                int i1 = i - input;
                if (dp.containsKey(i1)) {
                    List<Integer> currentList = new ArrayList<>(dp.get(i1));
                    currentList.add(input);
                    dp.put(i, currentList);
                }
            }
            ArrayList<Integer> currentList = new ArrayList<>();
            currentList.add(input);
            dp.put(input, currentList);
        }

        for (int i = target; i > 0; i--) {
            if (dp.containsKey(i)) {
                return dp.get(i);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(120, 200, 150, 90);
        List<Integer> selectRooms = selectRooms(list, 250);
        System.out.println(selectRooms);

    }
}
