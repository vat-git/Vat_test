package twentyfive.march.twentyfive;

public class SearchInsertOrder{

    public static void main(String[] args){
        int[] input ={1,3,5,6};
        searchInsert(input,7);
    }

    public static int searchInsert(int[] nums, int target) {


        int low=0;
        int high = nums.length-1;

        while(high>=low){

            int middle = low+ (high-low)/2;
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]<target){
                low=middle+1;
            }else{
                high=middle-1;
            }
        }
        int middle = low+ (high-low)/2;
        return middle;

    }

}