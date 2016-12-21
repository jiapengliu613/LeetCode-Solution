public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x <= 1) {
            return x;
        }
        int left = 1, right = x / 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid  > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return right  > x / right ? left : right;
    }
}