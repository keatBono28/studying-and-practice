package applications.arraypractice;

public class DominantIndex {

    public int domIndex(int[] nums){
        int largest = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if (i != index && (nums[i] * 2) > largest) {
                return -1;
            }
        }
        return index;
    }
}
