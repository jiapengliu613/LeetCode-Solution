public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            int dis1 = pos > 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int dis2 = pos < heaters.length ? heaters[pos] - house : Integer.MAX_VALUE;
            result = Math.max(result, Math.min(dis1, dis2));
        }
        return result;
    }
}