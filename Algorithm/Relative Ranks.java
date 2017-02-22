public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new String[0];
        }
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        int count = 0;
        for (Integer score : map.keySet()) {
            int pos = map.get(score);
            if (count == 0) {
                result[pos] = "Gold Medal";
            } else if (count == 1) {
                result[pos] = "Silver Medal";
            } else if (count == 2) {
                result[pos] = "Bronze Medal";
            } else {
                result[pos] = count + 1 + "";
            }
            count++;
        }
        return result;
    }
}