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
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int i = 0;
        int num = 0;
        boolean isInt = false;
        int sign = 1;
        NestedInteger current = null;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ',') {
                if (isInt) {
                    current.add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                    isInt = false;
                }
            } else if (Character.isDigit(c)) {
                isInt = true;
                num = num * 10 + c - '0';
            } else if (c == '[') {
                if (current != null) {
                    stack.push(current);
                }
                current = new NestedInteger();
            } else if (c == ']') {
                if (isInt) {
                    current.add(new NestedInteger(num * sign));
                    isInt = false;
                    num = 0;
                    sign = 1;
                }
                if (!stack.isEmpty()) {
                    NestedInteger peek = stack.pop();
                    peek.add(current);
                    current = peek;
                }
            } else if (c == '-') {
                sign = -1;
            }
            i++;
        }
        //System.out.println(current.isInteger());
        return current;
    }
}