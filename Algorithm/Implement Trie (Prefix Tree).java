class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
        
    }
    boolean isEnd = false;
    
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (current.children.containsKey(array[i])) {
                current = current.children.get(array[i]);
            } else {
                TrieNode newNode = new TrieNode();
                current.children.put(array[i], newNode);
                current = newNode;
            }
            if (i == word.length() - 1) {
                current.isEnd = true;
            }
        }
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.children.containsKey(word.charAt(i))) {
                
                return false;
            }
            
            current = current.children.get(word.charAt(i));
            //System.out.println(current.isEnd);
            if (i == word.length() - 1 && current.isEnd == false) {
                return false;
            }
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!current.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            current = current.children.get(prefix.charAt(i));
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");