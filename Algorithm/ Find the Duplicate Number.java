public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int start = 1, end = n;
        while (start + 1 < end) {
            int count = 0;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    count++;
                }
            }
            if (count < mid) {
                start = mid;
            } else {
                end = mid;
            }
            System.out.println("" + start + " " + end);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                count++;
            }
        }
        return count > 1 ? start : end;
    }
}