public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        int n = nums.length;
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Comparator<String> mycmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(array, mycmp);
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        if (array[0].charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}