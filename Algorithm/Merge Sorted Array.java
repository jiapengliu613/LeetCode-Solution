public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return ;
        }
        int[] array = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                array[index] = nums1[i];
                i++;
            } else {
                array[index] = nums2[j];
                j++;
            }
            index++;
        }
        for (; i < m; i++) {
            array[index] = nums1[i];
            index++;
        }
        for (; j < n; j++) {
            array[index] = nums2[j];
            index++;
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = array[i];
        }
        return ;
    }
}