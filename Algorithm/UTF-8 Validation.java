public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        if (data.length == 1) {
            return data[0] < 128;
        }
        int n = data.length;
        int index = 0;
        while (index < n) {
            if ((data[index] & 0xFF) >= 248) {
                return false;
            }
            int byteCnt = countBytes(data[index]);
            //System.out.println(byteCnt);
            index++;
            if (byteCnt == 1 || n - index < byteCnt - 1) {
                return false;
            }
            for (int i = 0; i < byteCnt - 1; i++) {
                if (index >= n || !isValid(data[index++])) {
                    //System.out.println("im here " + index + i);
                    return false;
                }
            }
            //index++;
        }
        return true;
    }
    private int countBytes(int number) {
        number = number & 0xFF;
        //System.out.println(number);
        int count = 0;
        int bit = 0x80;
        while ((number & bit) > 0) {
            count++;
            bit >>= 1;
        }
        return count;
    }
    
    private boolean isValid(int number) {
        number = number & 0xFF;
        //System.out.println(number);
        return number >= 128 && number < 192;
    }
}