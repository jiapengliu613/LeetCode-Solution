public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            if (s.length() == 0) {
                continue;
            }
            int offset = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = (char)(s.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                sb.append(c);
            }
            String current = sb.toString();
            if (!map.containsKey(current)) {
                map.put(current, new ArrayList<String>());
            }
            map.get(current).add(s);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}