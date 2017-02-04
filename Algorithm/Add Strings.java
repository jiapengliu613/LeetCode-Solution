public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int m = num1.length(), n = num2.length();
        int carry = 0;
        int num = 0;
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            num = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.insert(0,num);
        }
        while (i >= 0) {
            int a = num1.charAt(i) - '0';
            num = (a + carry) % 10;
            carry = (a + carry) / 10;
            sb.insert(0,num);
            i--;
        }
        while (j >= 0) {
            int b = num2.charAt(j) - '0';
            num = (b + carry) % 10;
            carry = (b + carry) / 10;
            sb.insert(0,num);
            j--;
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}