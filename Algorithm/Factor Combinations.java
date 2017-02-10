public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        helper(2, result, current, n);
        return result;
    }
    private void helper(int factor, List<List<Integer>> result, List<Integer> current, int remaining) {
        if (remaining == 1) {
            if (current.size() > 1) {
                result.add(new ArrayList<>(current));
            }
            return ;
        }
        for (int i = factor; i <= remaining; i++) {
            if (remaining % i == 0) {
                current.add(i);
                helper(i, result, current, remaining / i);
                current.remove(current.size() - 1);
            }
        }
       
    
    }
}