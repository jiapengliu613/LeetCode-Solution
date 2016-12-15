public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                if (i != nums.length - 1) {
                    continue;
                } else {
                    sb.append("->").append(nums[i]);
                    break;
                }
            }
            if (nums[i - 1] == Integer.parseInt(sb.toString())) {
                result.add(sb.toString());
            } else {
                sb.append("->").append(nums[i - 1]);
                result.add(sb.toString());
            }
            sb = new StringBuilder();
            sb.append(nums[i]);
        }
        result.add(sb.toString());
        return result;
    }
}