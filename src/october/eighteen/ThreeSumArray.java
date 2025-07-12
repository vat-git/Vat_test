package october.eighteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumArray {


    public static void main(String[] args) {
        int[] abcd = {-1, 2, 1, -1, -1, -1, 4, 5, 6};
        testThis("1", "2");

//        threeSum(abcd);
    }

    public static List<List<Integer>> threeSum(int[] nums) {





        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            throw new IllegalArgumentException("size is not correct");
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int required = 0 - nums[i];
                int start = i+1;
                int end = nums.length-1;
                while (start < end) {

                    int sum = nums[start] + nums[end];
                    if (sum > required) {
                        end = end - 1;
                    } else if (sum < required) {
                        start = start + 1;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while(start<end &&nums[start]==nums[start+1])start++;
                        while(start<end&&nums[end]==nums[end-1]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return result;
}

    private static void testThis(String... test) {
        String abcds = "this is %s first %s second %s third";
        System.out.println(String.format(abcds.replace("%s", "%s"), (Object[]) test));
    }
}
