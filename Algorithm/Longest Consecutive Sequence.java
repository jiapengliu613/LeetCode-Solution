public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                int count = 1;
                int val = num - 1;
                while (set.contains(val)) {
                    count++;
                    set.remove(val);
                    val--;
                }
                val = num + 1;
                while (set.contains(val)) {
                    count++;
                    set.remove(val);
                    val++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
        
        
        
        
        
        
        
        
        
        
        
        /*
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
        */
    }
}