public class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
       if (s == null || s.length() == 0) {
           return result;
       }
       int n = s.length();
       boolean[][] isPalin = new boolean[n][n];
       for (int i = 0; i < n; i++) {
           isPalin[i][i] = true;
       }
       for (int j = 1; j < n; j++) {
          for (int i = 0; i < j; i++) {
              if (j == i + 1) {
                  isPalin[i][j] = s.charAt(i) == s.charAt(j);
              } else {
                  isPalin[i][j] = s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1];
              }
          } 
       }
       List<String> current = new ArrayList<>();
       helper(s, isPalin, result, current, 0);
       return result;
    }
    private void helper(String s, boolean[][] isPalin, List<List<String>> result, List<String> current, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(current));
            return ;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String tmp = s.substring(index, i);
            if (isPalin[index][i - 1]) {
                current.add(tmp);
                helper(s, isPalin, result, current, i);
                current.remove(current.size() - 1);
            }
        }
    }
}