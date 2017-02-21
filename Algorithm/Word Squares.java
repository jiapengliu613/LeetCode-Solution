public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int n = words[0].length();
        Trie trie = new Trie(words);
        List<String> current = new ArrayList<>();
        for (String word : words) {
            current.add(word);
            helper(result, current, n, trie);
            current.remove(current.size() - 1);
        }
        return result;
    }
    
    private void helper(List<List<String>> result, List<String> current, int level, Trie trie) {
        if (current.size() == level) {
            result.add(new ArrayList<>(current));
            return;
        }
        StringBuilder sb = new StringBuilder();
        int index = current.size();
        for (String s : current) {
            sb.append(s.charAt(index));
        }
        for (String next : trie.findPrefix(sb.toString())) {
            current.add(next);
            helper(result, current, level, trie);
            current.remove(current.size() - 1);
        }
    }
    
    class TrieNode {
        List<String> prefix;
        TrieNode[] children;
        public TrieNode() {
            prefix = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode current = root;
                for (int i = 0; i < word.length(); i++) {
                    int pos = word.charAt(i) - 'a';
                    if (current.children[pos] == null) {
                        current.children[pos] = new TrieNode();
                    }
                    current = current.children[pos];
                    current.prefix.add(word);
                }
            }
        }
        public List<String> findPrefix(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (current.children[pos] == null) {
                    return new ArrayList<String>();
                }
                current = current.children[pos];
            }
            return current.prefix;
        }
    }
    
}