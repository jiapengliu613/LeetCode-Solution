public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k > n) {
            return result;
        }
        ArrayList<Integer> current = new ArrayList<>();
        helper(result, current, n, k, 1);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> current, int n, int k, int num) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        if (num > n) {
            return;
        }
        current.add(num);
        helper(result, current, n, k, num + 1);
        current.remove(current.size() - 1);
        helper(result, current, n, k, num + 1);
        
    }
}