public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];
        int carry = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int index = m + n - i - j - 2;
                int current = a * b + product[index];
                carry = current / 10;
                product[index] = current % 10;
                product[index + 1] += carry;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m + n - 1; i >= 0; i--) {
            if (sb.length() == 0 && product[i] == 0) {
                continue;
            }
            sb.append(product[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}