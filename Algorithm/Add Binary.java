public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int m = a.length(), n = b.length();
        int i = m - 1, j = n - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (; i >= 0 && j >= 0; i--, j--) {
            int sum = carry + a.charAt(i) - '0' + b.charAt(j) - '0';
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
        }
        //System.out.println("" + carry + " " + sb.toString() + " " + i + "" + j);
        for (; i >= 0; i--) {
            int sum = carry + a.charAt(i) - '0';
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
        }
        for (; j >= 0; j--) {
            int sum = carry + b.charAt(j) - '0';
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
        }
        
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}