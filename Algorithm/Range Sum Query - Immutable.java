public class NumArray {

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return ;
        }
       prefix = new int[nums.length];
       prefix[0] = nums[0];
       for (int i = 1; i < nums.length; i++) {
           prefix[i] = prefix[i - 1] + nums[i];
       }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return prefix[j];
        } else {
            return prefix[j] - prefix[i - 1];
        }
    }
    private int[] prefix;
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);