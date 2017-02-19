public class Solution {
    public int[] constructRectangle(int area) {
        if (area < 0) {
            return new int[2];
        }
        if (area == 1) {
            return new int[]{1, 1};
        }
        int[] result = new int[2];
        for (int i = (int)Math.sqrt(area); i<= area; i++) {
            if (i >= area / i && area % i == 0) {
                result[0] = i;
                result[1] = area / i;
                break;
            }
        }
        return result;
    }
}