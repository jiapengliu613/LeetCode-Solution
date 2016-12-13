public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /* TLE solution
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        int n = strs.length;
        //System.out.println(n);
        boolean[] used = new boolean[n];
        List<String> empty = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (used[i] == true) {
                continue;
            }
            if (strs[i].length() == 0) {
                System.out.println("im here");
                empty.add(strs[i]);
                //System.out.println(empty.size());
                used[i] = true;
                continue;
            }
            List<String> current = new ArrayList<>();
            
            current.add(strs[i]);
            used[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (used[j] == true) {
                    continue;
                }
                if (strs[j].length() == 0) {
                    empty.add(strs[j]);
                    used[j] = true;
                    continue;
                }
                HashMap<Character, Integer> map = new HashMap<>();
                for (char c : strs[i].toCharArray()) {
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    } else {
                        map.put(c, map.get(c) + 1);
                    }
                }
                int k;
                for (k = 0; k < strs[j].length();k++) {
                    if (!map.containsKey(strs[j].charAt(k))) {
                        break;
                    } else {
                        if (map.get(strs[j].charAt(k)) == 1) {
                            map.remove(strs[j].charAt(k));
                        } else {
                            map.put(strs[j].charAt(k), map.get(strs[j].charAt(k)) - 1);
                        }
                    }
                }
                if (k == strs[j].length() && map.isEmpty()) {
                    current.add(strs[j]);
                    used[j] = true;
                }
            }
            
            result.add(current);
            
        }
        if (empty.size() > 0) {
            result.add(empty);
        }
        return result;
        */
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String current = String.valueOf(array);
            if (!map.containsKey(current)) {
                map.put(current, new ArrayList<String>());
            }
            map.get(current).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}