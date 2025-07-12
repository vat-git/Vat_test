package october;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TwoSum {

    public static void main(String[] args) {
        int[] ints = {3, 2, 4};
        twoSum(ints, 6);
    }

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[2];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
            int rest = target - nums[i];
            if (map.containsKey(rest)) {
                return new int[]{i, map.get(rest)};
            }
        }
        return new int[]{0, 1};
    }


}
