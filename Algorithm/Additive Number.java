public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        int n = num.length();
        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i >= 2) {
                return false;
            } 
            for (int j = i + 1; n - j >= j - i && n - j >= i; j++) {
                if (j - i >= 2 && num.charAt(i) == '0') {
                    break;
                }
                String str1 = num.substring(0, i);
                String str2 = num.substring(i, j);
                String str = num.substring(j);
                long num1 = Long.parseLong(str1);
                long num2 = Long.parseLong(str2);
                if (isAddtive(str, num1, num2) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isAddtive(String s, long num1, long num2) {
        if (s.equals("")) {
            return true;
        }
        long sum = num1 + num2;
        String start = ((Long)sum).toString();
        if (!s.startsWith(start)) {
            return false;
        }
        return isAddtive(s.substring(start.length()), num2, sum);
    }
}