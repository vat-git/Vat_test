package jul;

import java.util.Arrays;

public class TwoSum {

        public int[] twoSum(int[] nums, int target) {
            for (int firstIndex = 0; firstIndex < nums.length-1; firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                    int firstNumber = nums[firstIndex];
                    int secondNumber = nums[secondIndex];
                    if (firstNumber + secondNumber == target) {
                        return new int[]{firstIndex, secondIndex};
                    }
                }
            }
            return new int[]{};
        }
}
