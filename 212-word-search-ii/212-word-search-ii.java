class Solution {
    final int[][] moves = new int[][] {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    
    List<String> result = new ArrayList<>();
    Trie root = new Trie();
    
    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                dfs(board, i, j, root);
            }
        }
        
        return result;
    }
    
    void dfs(char[][] board, int x, int y, Trie root) {
        char c = board[x][y];
        
        if (!root.next.containsKey(c)) return;
        
        Trie next = root.next.get(c);
        
        board[x][y] = '#';
        
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        
        for(int[] move : moves) {
            int nx = x + move[0];
            int ny = y + move[1];
            
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            
            dfs(board, nx, ny, next);
        }
        
        if (next.word == null && next.next.isEmpty()) root.next.remove(c);
        
        board[x][y] = c;
    }
    
    void buildTrie(String[] words) {
        for(String w : words) {
            Trie current = root;
            
            for(char c : w.toCharArray()) {
                current = current.next.computeIfAbsent(c, k -> new Trie());
            }
            
            current.word = w;
        }
    }
    
    class Trie {
        public Map<Character, Trie> next = new HashMap<>();
        String word = null;
    }
}