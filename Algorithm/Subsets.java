public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        helper(nums, result, current, 0);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        current.add(nums[index]);
        helper(nums, result, current, index + 1);
        current.remove(current.size() - 1);
        helper(nums, result, current, index + 1);
    }
}