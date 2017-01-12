public class Solution {
    public int lastRemaining(int n) {
        if (n <= 1) {
            return 1;
        }
        int remaining = n;
        boolean isLeft = true;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (isLeft || remaining % 2 == 1) {
                head += step;
            }
            isLeft = !isLeft;
            step *= 2;
            remaining /= 2;
        }
        return head;
    }
}