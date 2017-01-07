public class Solution {
    public int nthUglyNumber(int n) {
        /* O(nlog(n))
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer((long)2);
        pq.offer((long)3);
        pq.offer((long)5);
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = pq.poll();
            pq.offer(result * 2);
            pq.offer(result * 3);
            pq.offer(result * 5);
            while (!pq.isEmpty() && result == pq.peek()) {
                pq.poll();
            }
        }
        return (int)result;
        */
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int index2 = 0, index3 = 0, index5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int currentMin = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = currentMin;
            if (currentMin == factor2) {
                factor2 = 2 * ugly[++index2];
            }
            if (currentMin == factor3) {
                factor3 = 3 * ugly[++index3];
            }
            if (currentMin == factor5) {
                factor5 = 5 * ugly[++index5];
            }
        }
        return ugly[n - 1];
        
    }
}