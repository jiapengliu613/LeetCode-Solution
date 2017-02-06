public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        // here long to prevent num overflow
        long num = 9;
        
        int length = 1, base = 1;
        while (n > num * length) {
            n -= num * length;
            num *= 10;
            base *= 10;
            length++;
        }
        
        
        int count = base + (n - 1) / length;
        String s = Integer.toString(count);
        //System.out.println(n);
        return s.charAt((n - 1) % length) - '0';
    }
}