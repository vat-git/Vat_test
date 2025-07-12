package twentyfive.april.eight;

public class MinimumOperationDistinctArray {
public static void main(String[] args){
    int[] test = {2,2,6,13,6,13};
    System.out.println(minimumOperations(test));
}

  public static int minimumOperations(int[] nums) {

    if(nums.length<2){
      return 0;
    }
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        if(nums[i]==nums[j]){
          counter++;
          i=counter*3-1;
          break;
        }
      }
    }
    return counter;
  }
}
