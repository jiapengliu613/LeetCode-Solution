/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     private int bufferPtr;
     private int bufferCnt;
     private char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (bufferPtr == 0) {
                bufferCnt = read4(buffer);
            }
            if (bufferCnt == 0) {
                break;
            }
            while (index < n && bufferPtr < bufferCnt) {
                buf[index++] = buffer[bufferPtr++];
            }
            if (bufferPtr == bufferCnt) {
                bufferPtr = 0;
            }
        }
        return index;
    }
}