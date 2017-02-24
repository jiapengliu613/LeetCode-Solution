public class Solution {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], (map.getOrDefault(transaction[0], 0) + transaction[2]));
            map.put(transaction[1], (map.getOrDefault(transaction[1], 0) - transaction[2]));
        }
        List<Integer> debt = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) != 0) {
                debt.add(map.get(key));
            }
        }
        return helper(0, 0, debt);
        
        
    }
    private int helper(int pos, int count, List<Integer> debt) {
        
        while (pos < debt.size() && debt.get(pos) == 0) {
            pos++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = pos + 1; i < debt.size(); i++) {
            if (debt.get(pos) * debt.get(i) >= 0) {
                continue;
            }
            //if (pos == 2 && i == 3)
               // System.out.println(count);
            
            debt.set(i, debt.get(i) + debt.get(pos));
            result = Math.min(result, helper(pos + 1, count + 1, debt));
            debt.set(i, debt.get(i) - debt.get(pos));
        }
        return result == Integer.MAX_VALUE ? count : result;
    }
    //private int result = Integer.MAX_VALUE;
}