public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        helper(result, current, k, n, 1);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> current, int numLeft, int target, int pos) {
        
        
        if (target < 0) {
            return ;
        }
        if (target > 0 && numLeft == 0) {
            return ;
        }
        if (target == 0) {
            //System.out.println(current.toString() + " " + numLeft);
            if (numLeft == 0) {
                result.add(new ArrayList<Integer>(current));
            }
            return ;
        }
        if (pos > 9) {
            return ;
        }
        current.add(pos);
        helper(result, current, numLeft - 1, target - pos, pos + 1);
        current.remove(current.size() - 1);
        helper(result, current, numLeft, target, pos + 1);
    }

}