public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int result = 0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '+') {
                flag = 1;
                continue;
            } else if(i == 0 && str.charAt(i) == '-') {
                flag = -1;
                continue;
            }
            if (str.charAt(i) - '0' > 9 || str.charAt(i) - '0' < 0) {
                break;
            }
            
            if (Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE %10 < str.charAt(i) - '0') {
                //System.out.println("im here");
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                
            }
            result = result * 10 + str.charAt(i) - '0';
        }
        return result * flag;
    }
}