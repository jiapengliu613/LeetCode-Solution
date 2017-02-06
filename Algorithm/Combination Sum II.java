public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        helper(candidates, 0, target, result, current);
        return result;
    }
    
    private void helper(int[] candidates, int index, int remaining, List<List<Integer>> result, List<Integer> current) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return ;
        }
            
        if (index == candidates.length) {
            return ;
        }
        if (remaining < 0) {
            return ;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            helper(candidates, i + 1, remaining - candidates[i], result, current);
            current.remove(current.size() - 1);
        }
    }
}