public class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }
        if (k > 26) {
            return "";
        }
        int[] count = new int[26];
        int[] validPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = findPos(count, validPos, i);
            //System.out.println(index);
            if (index == -1) {
                return "";
            }
            sb.append((char)('a' + index));
            count[index]--;
            validPos[index] += k;
        }
        return sb.toString();
    }
    
    private int findPos(int[] map, int[] pos, int index) {
        int maxCnt = 0;
        int result = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > maxCnt && pos[i] <= index) {
                maxCnt = map[i];
                result = i;
            }
        }
        return result;
    }
}