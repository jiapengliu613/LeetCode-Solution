public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int reminder = num % 10;
                sum += reminder;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }
}