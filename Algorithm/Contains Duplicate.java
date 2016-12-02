public class Solution {
    public boolean containsDuplicate(int[] nums) {
       
       /* TLE for this solution although it's O(n) time
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
        */
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}