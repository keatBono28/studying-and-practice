package applications.arraypractice;

public class PivotArrays {

    public int pivotIndex(int[] nums){
        // https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/

        int sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
        }
        int left_sum = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(i != 0){
                left_sum += nums[i-1];
            }
            if(sum - left_sum - nums[i] == left_sum){
                return i;
            }
        }
        return -1;
    }


}
