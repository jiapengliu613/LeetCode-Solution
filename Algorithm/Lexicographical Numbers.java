public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        for (int i = 1; i < 10; i++) {
        
            helper(result, i, n);
        }
        return result;
    }
    private void helper(List<Integer> result, int current, int n) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i < 10; i++) {
            if (current * 10 + i > n) {
                break;
            }
            helper(result, current * 10 + i, n);
        }
    }
}