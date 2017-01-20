public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        helper(result, nums, current, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> current, int pos) {
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            swap(nums, i, pos);
            set.add(nums[pos]);
            current.add(nums[pos]);
            helper(result, nums, current, pos + 1);
            current.remove(current.size() - 1);
            swap(nums, i, pos);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}