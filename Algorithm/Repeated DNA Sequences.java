public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<String>();
        }
        HashSet<Integer> oneTime = new HashSet<>();
        HashSet<Integer> twoTime = new HashSet<>();
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            int code = 0;
            for (int j = i; j < i + 10; j++) {
                code <<= 2;
                code = code | map[s.charAt(j) - 'A'];
            }
            if (oneTime.add(code)) {
                continue;
            } else if (twoTime.add(code)) {
                result.add(s.substring(i, i + 10));
            }
        }
        return result;
    }
}