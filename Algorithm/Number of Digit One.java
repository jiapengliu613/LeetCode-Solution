public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            count += (r + 8) / 10 * k;
            if (r % 10 == 1) {
                count += m + 1;
            }
        }
        return count;
    }
}