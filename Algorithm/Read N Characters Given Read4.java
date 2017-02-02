/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        //int count = 0;
        int index = 0;
        boolean eof = false;
        while (true) {
            int current = read4(buffer);
            int readNum = Math.min(current, n - index);
            
            for (int i = 0; i < readNum; i++) {
                buf[i + index] = buffer[i];
            }
            
            index += readNum;
            if (readNum < 4 || index == n) {
                break;
            }
        }
        return index;
    }
}