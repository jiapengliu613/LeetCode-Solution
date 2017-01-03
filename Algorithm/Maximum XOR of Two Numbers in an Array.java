public class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        for (int num : nums) {
            buildTrie(root, num);
        }
        int result = 0;
        for (int num : nums) {
            int maxXor = findXor(root, num);
            result = Math.max(result, num ^ maxXor);
        }
        return result;
    }
    
    private void buildTrie(TrieNode root, int num) {
        TrieNode current = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.next[bit] == null) {
                current.next[bit] = new TrieNode();
            }
            current = current.next[bit];
        }
    }
    private int findXor(TrieNode root, int num) {
        int result = 0;
        TrieNode current = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (current.next[1 - bit] != null) {
                current = current.next[1 - bit];
                result |= (1 - bit) << i;
            } else {
                current = current.next[bit];
                result |= bit << i;
            }
        }
        return result;
    }
    class TrieNode {
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[2];
        }
    }
}