/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private int result = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int depth = getDepth(nestedList);
        helper(nestedList, depth);
        return result;
    }
    
    private int getDepth(List<NestedInteger> list) {
        //int depth = 0;
        int max = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()) {
                continue;
            }
            max = Math.max(max, getDepth(list.get(i).getList()) + 1);
        }
        return max;
    }
    
    private void helper(List<NestedInteger> list, int depth) {
        if (list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInteger()) {
                result += list.get(i).getInteger() * depth;
            } else {
                helper(list.get(i).getList(), depth - 1);
            }
        }
    }
}