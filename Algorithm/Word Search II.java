public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        Trie tree = new Trie();
        //Map<String, Boolean> visited = new HashMap<>();
        for (String word : words) {
            tree.insert(word);
            //System.out.println(tree.startWith(word));
            //visited.put(word, false);
        }
        
        //StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(tree.root, board, result, i, j);
            }
        }
        
        return result;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    private void helper(TrieNode current, char[][] board, List<String> result,  int i, int j) {
        int m = board.length, n = board[0].length;
        if (current.word != null) {
            result.add(current.word);
            current.word = null;
        }
        if (i == m || i < 0 || j == n || j < 0 || board[i][j] == '#') {
            return ;
        }
        char c = board[i][j];
        if (!current.children.containsKey(c)) {
            return;
        }
        
        
        
        board[i][j] = '#';
        for (int index = 0; index < 4; index++) {
            int newX = i + dx[index];
            int newY = j + dy[index];
            
            helper(current.children.get(c), board, result, newX, newY);
            
        }
        board[i][j] = c;
    }
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String s) {
            TrieNode current = root;
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (current.children.containsKey(array[i])) {
                    current = current.children.get(array[i]);
                } else {
                    TrieNode child = new TrieNode();
                    current.children.put(array[i], child);
                    current = child;
                }
            }
            current.word = s;
        }
        /*
        private boolean startWith(String prefix) {
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
        */
    }
}