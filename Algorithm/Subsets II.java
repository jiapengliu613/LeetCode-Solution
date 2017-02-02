public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        helper(result, current, 0, nums);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> current, int index, int[] nums) {
        result.add(new ArrayList<Integer>(current));
        if (index == nums.length) {
            return ;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            helper(result, current, i + 1, nums);
            current.remove(current.size() - 1);
        }
    }
}