public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return new int[0];
        }
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
            int[] sub1 = getSubarray(nums1, i);
            int[] sub2 = getSubarray(nums2, k - i);
            int[] merged = mergeSub(sub1, sub2, k);
            if (isGreater(merged, 0, result, 0)) {
                result = merged;
            }
            
        }
        
        return result;
    }
    
    private int[] getSubarray(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && nums.length - k > i - len && result[len - 1] < nums[i]) {
                len--;
            }
            if (len < k) {
                result[len++] = nums[i];
            }
        }
        return result;
    }
    
    private int[] mergeSub(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int pos1 = 0, pos2 = 0;
        for (int i = 0; i < k; i++) {
            if (isGreater(nums1, pos1, nums2, pos2)) {
                result[i] = nums1[pos1++];
            } else {
                result[i] = nums2[pos2++];
            }
        }
        return result;
    }
    
    private boolean isGreater(int[] nums1, int pos1, int[] nums2, int pos2) {
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] > nums2[pos2]) {
                return true;
            } else if (nums1[pos1] < nums2[pos2]) {
                return false;
            } else {
                pos1++;
                pos2++;
            }
        }
        return pos1 != nums1.length;
    }
}