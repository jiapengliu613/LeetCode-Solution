public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        int[] result = new int[nums2.length];
        int index = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                set.remove(num);
                result[index] = num;
                index++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }
}