public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int start = 0, end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= (n - mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start] >= (n - start)) {
            return n - start;
        } else if (citations[end] >= (n - end)){
            return n - end;
        } else {
            return 0;
        }
        
        
        
        /*
        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= (n - i)) {
                result = n - i;
            }
        }
        return result;
        */
    }
}