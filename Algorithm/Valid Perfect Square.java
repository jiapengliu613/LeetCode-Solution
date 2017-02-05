public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int start = 1, end = num / 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (1.0 * num / mid == (double)mid) {
                return true;
            } else if (1.0 * num / mid <(double)mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (1.0 * num / start == (double)start) {
            return true;
        } else if (1.0 * num / end == (double)end) {
            return true;
        } else {
            return false;
        }
        
        
        /*
        for (int i = 1; i <= num / 2; i++) {
            if (1.0 * num / i == (double)i) {
                return true;
            }
        }
        return false;
        */
    }
}