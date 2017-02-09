public class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        if (word == null) {
            return ;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            if (i == word.length() - 1) {
                current.isEnd = true;
            }
        }
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(root, word);
    }
    private boolean searchWord(TrieNode current, String word) {
        //System.out.println("im here " + current.children.keySet() + " " + word);
        if (word == null || word.length() == 0) {
            //System.out.println(current.isEnd);
            return current.isEnd;
        }
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode next : current.children.values()) {
                    
                    if (searchWord(next, word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!current.children.containsKey(c)) {
                    //System.out.println("im here " + c);
                    break;
                }
                current = current.children.get(c);
                if (i == word.length() - 1 && current.isEnd == true) {
                    return true;
                }
                
            }
        }
        return false;
    }
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd = false;
        public TrieNode() {
            children = new HashMap<>();
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */