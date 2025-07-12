package twentyfive.july.one;

public class EqualPartition {

    public boolean canPartition(int[] nums) {

      int totalSum = 0;
      for (int num : nums) {
        totalSum = totalSum + num;
      }

      if (totalSum % 2 != 0) {
        return false;
      }

      int target = totalSum / 2;

      boolean[] dp = new boolean[target+1];
      dp[0] = true;
      for (int num : nums) {

        for (int i = target; i >= num; i--) {
          dp[i] = dp[i - num] || dp[i];
        }
              }

      return dp[target];



    }

}
