public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                //count++;
            } else {
                if ((n + 1) % 4 == 0 && n != 3) {
                    n = n + 1;
                    //count++;
                } else {
                    n -= 1;
                }
            }
            count++;
        }
        return count;
    }
}