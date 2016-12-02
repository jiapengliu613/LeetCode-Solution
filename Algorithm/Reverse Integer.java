public class Solution {
    public int reverse(int x) {
        int result = 0;
        int flag = 0;
        if (x < 0) {
            x = -x;
            flag = 1;
        }
        //x = x >= 0 ? x : -x;
        while (x > 0) {
            int reminder = x % 10;
            int newResult = 10 * result + reminder;
            x = x / 10;
            if ((newResult - reminder) / 10 != result) {
                return 0;
            }
            result = newResult;
        }
        
        return flag == 0 ? result : -result;
    }
}