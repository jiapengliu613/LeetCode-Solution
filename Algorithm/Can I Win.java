public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal < maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        int used = 0;
        return helper(map, used, maxChoosableInteger, desiredTotal);
    }
    private boolean helper(Map<Integer, Boolean> map, int used, int max, int left) {
        if (map.containsKey(used)) {
            return map.get(used);
        }
        for (int i = 1; i <= max; i++) {
            if ((used & (1 << i)) == 0) {
                
                if (i >= left || !helper(map, used | (1 << i), max, left - i)) {
                    map.put(used, true);
                    return true;
                }
            
            }
        }
        map.put(used, false);
        return false;
    }
    
}