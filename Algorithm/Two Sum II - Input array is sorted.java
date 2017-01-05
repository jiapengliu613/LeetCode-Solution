public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[2];
        }
        int start = 0, end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            //int mid = start + (end - start) / 2;
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end --;
            }
        }
        return result;
    }
}