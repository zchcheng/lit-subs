class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (root.next.containsKey(board[i][j])) 
                    helper(root, i, j, board);
            }
        }
        
        return res;
    }
    
    Trie buildTrie(String[] words) {
        Trie root = new Trie();
        
        for(String word : words) {
            Trie cur = root;
            
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur = cur.next.computeIfAbsent(c, k -> new Trie());
            }
            
            cur.hasWord = true;
            cur.word = word;
        }
        
        return root;
    }
    
    void helper(Trie node, int i, int j, char[][] board) {
        char c = board[i][j];
        board[i][j] = '#';
        
        Trie nextNode = node.next.get(c);
        
        if (nextNode == null) {
            board[i][j] = c;
            return;
        }
        
        if (nextNode.hasWord && !nextNode.added) {
            res.add(nextNode.word);
            nextNode.added = true;
        }
        
        for(int[] mv : new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        }) {
            int ni = i + mv[0];
            int nj = j + mv[1];
            
            if (ni < 0 || nj < 0 || ni >= board.length || nj >= board[0].length || board[ni][nj] == '#') continue;
            
            helper(nextNode, ni, nj, board);
        }
        
        board[i][j] = c;
    }
    
    class Trie {
        public Map<Character, Trie> next = new HashMap<>();
        public boolean hasWord = false;
        public boolean added = false;
        public String word = "";
    }
}