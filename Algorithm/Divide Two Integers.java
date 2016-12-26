public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0 ) ^ (divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int result = 0;
        while (ldividend >= ldivisor) {
            long tmp = ldivisor, count = 1;
            while (ldividend >= (tmp << 1)) {
                tmp <<= 1;
                count <<= 1;
            }
            result += count;
            ldividend -= tmp;
        }
        return sign == 1 ? result : - result;
    }
}