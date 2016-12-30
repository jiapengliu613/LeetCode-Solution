public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        Integer[] result = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = helper(nums[i], root, 0, result, i);
            //System.out.print(root.val + " ");
        }
        return Arrays.asList(result);
    }
    private Node helper(int num, Node node, int preSum, Integer[] result, int index) {
        if (node == null) {
            node = new Node(num, 0);
            result[index] = preSum;
        } else if (node.val == num) {
            node.dup++;
            result[index] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = helper(num, node.left, preSum, result, index);
        } else {
            node.right = helper(num, node.right, preSum + node.sum + node.dup, result, index);
        }
        return node;
    }
    class Node {
        int val;
        int sum;
        int dup = 1;
        Node left = null;
        Node right = null;
        public Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }
}