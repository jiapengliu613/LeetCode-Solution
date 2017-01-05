public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int newTarget = target - nums[i] - nums[j];
                int left = j + 1, right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == newTarget) {
                        List<Integer> current = new ArrayList<>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[left]);
                        current.add(nums[right]);
                        result.add(current);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (nums[left] + nums[right] < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}