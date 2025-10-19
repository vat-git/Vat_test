package twentyfive.oct.eighteenth;

public class HouseRobber2 {

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 18, 1, 2, 20, 1, 3, 4};
        rob(input);
    }

    public static int rob(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int size = nums.length;

//        int maxCase1 = findMax(nums, 0, size - 2);
        int maxCase2 = findMax(nums, 0, size - 1);

        return maxCase2;
//        return Math.max(maxCase1, maxCase2);

    }

    private static int findMax(int[] nums, int i, int i1) {

        int prev1 = 0;
        int prev2 = 0;
        for (int j = i; j <= i1; j++) {

            int num = nums[j];
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;

        }
        return prev1;
    }
}

