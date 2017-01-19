public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] array = new int[n + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= n) {
                array[n]++;
            } else {
                array[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += array[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
        /*
        Arrays.sort(citations);
        int start = 0, end = citations.length - 1;
        while (start < end) {
            int tmp = citations[start];
            citations[start] = citations[end];
            citations[end] = tmp;
            start++;
            end--;
        }
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1) {
                result = i + 1;
            }
        }
        return result;
        */
    }
}