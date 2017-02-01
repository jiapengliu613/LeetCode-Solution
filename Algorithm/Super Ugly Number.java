public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return  1;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] index = new int[primes.length];
        int[] factor = new int[primes.length];
        for (int i = 0; i < factor.length; i++) {
            factor[i] = primes[i];
        }
        //int result = factor[0];
        for (int i = 1; i < n; i++) {
            ugly[i] = factor[0];
            for (int j = 0; j < factor.length; j++) {
                ugly[i] = Math.min(ugly[i], factor[j]);
            }
            for (int j = 0; j < factor.length; j++) {
                if (factor[j] == ugly[i]) {
                    index[j] += 1;
                    factor[j] = primes[j] * ugly[index[j]];
                }
            }
            //System.out.println(factor[0]);
        }
        return ugly[n - 1];
        
        
        
        
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int prime : primes) {
            pq.offer(prime);
        }
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = pq.peek();
            while (!pq.isEmpty() && pq.peek() == result) {
                pq.poll();
            }
            for (int prime : primes) {
                if (result < Integer.MAX_VALUE / prime) {
                    pq.offer(result * prime);
                }
            }
        }
        */
        //return result;
    }
}