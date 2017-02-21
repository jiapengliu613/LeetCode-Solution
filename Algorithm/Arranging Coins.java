public class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((mid + 1)  <= 1.0 * n / mid * 2) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end <= 1.0 * n * 2 / (end + 1)) {
            return end;
        }
        return start;
    }
}