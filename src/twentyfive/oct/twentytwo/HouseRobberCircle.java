package twentyfive.oct.twentytwo;

public class HouseRobberCircle {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        int firstCombination = findMax(0, nums.length - 2,nums);
        int secondCombination = findMax(1, nums.length - 1,nums);
        return Math.max(firstCombination, secondCombination);
    }

    private int findMax(int start, int end, int[] nums) {

        //3,4,5,1,6
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

}
