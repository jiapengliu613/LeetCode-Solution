public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        // cut position
        int start = 0, end = m; 
        int halfLen = (m + n + 1) / 2;
        while (start <= end) {
            // the start of right side is i, which means left side has i elements
            int i = (start + end) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                start = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            } else {
                int leftMax;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                } else {
                    int rightMin;
                    if (i == m) {
                        rightMin = nums2[j];
                    } else if (j == n) {
                        rightMin = nums1[i];
                    } else {
                        rightMin = Math.min(nums1[i], nums2[j]);
                    }
                    return (leftMax + rightMin) / 2.0;
                }
            }
            
        }
        return Integer.MIN_VALUE;
    }
}