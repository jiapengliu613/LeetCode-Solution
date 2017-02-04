public class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n;i++) {
            init(i, nums[i]);
        }
    }
    private void init(int i, int val) {
        for (int j = i + 1; j <= n; j += j & (-j)) {
            tree[j] += val;
        }
    }
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
        
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    private int getSum(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    } 
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */