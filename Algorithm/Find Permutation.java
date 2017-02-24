public class Solution {
    public int[] findPermutation(String s) {
        if (s == null || s.length() == 0) {
            return new int[0];
        }
        int n = s.length();
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = i + 1;
        }
        int slow = 0, fast = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int j = i;
                while (i < s.length() && s.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, j, i);
            }
        }
        return result;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}