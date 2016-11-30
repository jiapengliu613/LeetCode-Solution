public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int n = digits.length;
        int[] result = new int[n + 1];
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i + 1] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry == 1) {
            result[0] = 1;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, n + 1);
        }
    }
}