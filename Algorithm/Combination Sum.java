public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        helper(candidates, result, current, target, 0);
        return result;
    }
    private void helper(int[] candidates, List<List<Integer>> result, List<Integer> current, int target, int i) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        current.add(candidates[i]);
        helper(candidates, result, current, target - candidates[i], i);
        current.remove(current.size() - 1);
        helper(candidates, result, current, target, i + 1);
        
    }
}