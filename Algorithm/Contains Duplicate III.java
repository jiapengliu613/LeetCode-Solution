public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int n = nums.length;
        
        TreeSet<Integer> map = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Integer floor = map.floor(nums[i] + t);
            Integer ceil = map.ceiling(nums[i] - t);
            if ((floor != null && Math.abs(floor - nums[i]) <= t) ||
                (ceil != null && Math.abs(ceil - nums[i]) <= t)) {
                 return true;
             }
             map.add(nums[i]);
             if (map.size() > k) {
                 map.remove(nums[i - k]);
             }
        }
        return false;
    }
}