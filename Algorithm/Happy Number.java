public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slow = n, fast = n;

       do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return slow == 1;
    }
    private int squareSum(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }
}