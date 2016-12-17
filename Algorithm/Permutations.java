public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(nums, result, current, 0);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            current.add(nums[index]);
            helper(nums, result, current, index + 1);
            current.remove(current.size() - 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}