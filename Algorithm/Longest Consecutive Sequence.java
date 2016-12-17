public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);
                int val = num - 1;
                while (set.contains(val)) {
                    set.remove(val);
                    val--;
                    count++;
                }
                val = num + 1;
                while (set.contains(val)) {
                    set.remove(val);
                    val++;
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}