package twentyfive.nov;

public class LongestOnes {

    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int right=0;
        int current = 0;
        int answer = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                current++;
            }

            while (current > k) {
                if(nums[left]==0) {
                    current--;
                }
                left++;

            }
            answer = Math.max(answer, right - left+1);
            right++;

        }
        return answer;
    }

}
