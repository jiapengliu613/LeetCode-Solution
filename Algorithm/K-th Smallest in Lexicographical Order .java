public class Solution {
    private int result;
    public int findKthNumber(int n, int k) {
        if (n < 1 || k < 1) {
            return 0;
        }
        int cur = 1;
        k = k - 1;
        while (k > 0) {
            int step = countSteps(n, cur, cur + 1);
            if (step <= k) {
                k -= step;
                cur += 1;
            } else {
                k -= 1;
                cur *= 10;
            }
        }
        return cur;
    }
    
    private int countSteps(int n, long num1, long num2) {
        int step = 0;
        while (num1 <= n) {
            if (num2 > n) {
                step += n + 1 - num1;
            } else {
                step += num2 - num1;
            }
            num1 *= 10;
            num2 *= 10;
        }
        return step;
    }
}