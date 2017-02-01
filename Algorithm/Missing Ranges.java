public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int lowerBound = lower;
        for (int num : nums) {
            if (num < lowerBound) {
                continue;
            }
            if (num == lowerBound) {
                lowerBound++;
                continue;
            } 
            String s = getRange(lowerBound, num - 1);
            result.add(s);
            lowerBound = num + 1;
            if(lowerBound == Integer.MIN_VALUE) {
                break;
            }
            
        }
        if ((lowerBound <= upper && lowerBound != Integer.MIN_VALUE) || nums.length == 0) {
            result.add(getRange(lowerBound, upper));
        }
        return result;
    }
    
    private String getRange(int lower, int upper) {
        if (lower == upper) {
            return lower + "";
        } else {
            return lower + "->" + upper;
        }
    }
}