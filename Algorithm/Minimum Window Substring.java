public class Solution {
    public String minWindow(String s, String t) {
      if (s == null || t == null || s.length() < t.length()) {
          return "";
      }  
      HashMap<Character, Integer> map = new HashMap<>();
      
      for (char c : t.toCharArray()) {
          if (!map.containsKey(c)) {
              map.put(c, 1);
          } else {
              map.put(c, map.get(c) + 1);
          }
      }
      int count = t.length();
      int slow = 0, fast = 0, head = 0;
      int result = Integer.MAX_VALUE;
      int n = s.length();
      while (fast < n) {
          char c = s.charAt(fast);
          fast++;
          if (map.containsKey(c)) {
              map.put(c, map.get(c) - 1);
              if (map.get(c) >= 0) {
                  count--;
              }
          } else {
              map.put(c, -1);
          }
          while (count == 0) {
              if (fast - slow < result) {
                result = fast - slow;
                head = slow;
              }
              if (map.get(s.charAt(slow)) == 0) {
                  count++;
              }
              map.put(s.charAt(slow), map.get(s.charAt(slow)) + 1);
              slow++;
          }
      }
      //System.out.println(head +" " + result);
      return result == Integer.MAX_VALUE ? "" : s.substring(head, head + result);
    }
}