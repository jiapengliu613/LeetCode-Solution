public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int n = height.length;
        int left = 0, right = n - 1;
        int max = 0;
        while (left + 1 < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                while (left < right && height[left] >= height[left + 1]) {
                    left++;
                }
                left++;
            } else if (height[left] > height[right]) {
                while (left < right && height[right] >= height[right - 1]) {
                    right--;
                }
                right--;
            } else {
                left++;
            }
        }
        max = Math.max(max, Math.min(height[left], height[right]));
        return max;
    }
}