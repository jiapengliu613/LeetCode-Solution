public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        char odd ='a';
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                count++;
                odd = c;
            }
            if (count > 1) {
                return result;
            }
        }
        //System.out.println(map.entrySet());
        StringBuilder sb = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        if (count == 0) {
            helper(result, map, sb, n, mid);
        } else {
            mid.append(odd);
            map.put(odd, map.get(odd) - 1);
            helper(result, map, sb, n - 1, mid);
        }
        return result;
    }
    //Character mid = null;
    private void helper(List<String> result, Map<Character, Integer> map, StringBuilder sb, int n, StringBuilder mid) {
        //System.out.println(sb.toString());
        if (sb.length() == n) {
            //System.out.println(map.size());
            sb.insert(sb.length() / 2, mid.toString());
            result.add(sb.toString());
            if (mid.length() > 0) {
                sb.deleteCharAt(sb.length() / 2);
            }
            return ;
        }
        
        //System.out.println(sb.toString());
        for (Character c : map.keySet()) {
            if (map.get(c) == 0) {
                continue;
            }
            
            
            sb.insert(0, c);
            sb.insert(sb.length(), c);
            map.put(c, map.get(c) - 2);
            
            
            helper(result, map, sb, n, mid);
            map.put(c, map.get(c) + 2);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            
                
            
        }
    }
}