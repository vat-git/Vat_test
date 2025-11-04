package twentyfive.nov.fourth;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle]<target) {
                left = middle + 1;
            }else {
                return nums[middle];
            }
        }
        return -1;
    }
}
