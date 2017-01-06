public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int pos = mid;
                while (pos >= 0 && nums[pos] == target) {
                    pos--;
                }
                result[0] = pos + 1;
                pos = mid;
                while (pos < nums.length && nums[pos] == target) {
                    pos++;
                }
                result[1] = pos - 1;
                return result;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target && nums[end] == target) {
            result[0] = start;
            result[1] = end;
            
        } else if (nums[start] == target) {
            result[0] = start;
            result[1] = start;
            
        } else if (nums[end] == target) {
            result[0] = end;
            result[1] = end;
        }
        return result;
    }
}