package twentyfive.april.nine;

public class MinimumOperationsToK {

 
  public static int minOperations(int[] nums, int k) {

    int highestNumber = 0;
    int highestNumberCount = 0;
    for (int num : nums) {
      if (num > highestNumber) {
        highestNumberCount = 1;
        highestNumber = num;
      }
      if (num == highestNumber) {
        highestNumberCount++;
      }
    }
    return nums.length - highestNumberCount;

  }

}
