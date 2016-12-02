public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int left = 0, right = n - 1;
        while (left < right && height[left] <= height[left + 1]) {
            left++;
        }
        while (left < right && height[right] <= height[right - 1]) {
            right--;
        }
        int result = 0;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
            }
        }
        return result;
    }
}