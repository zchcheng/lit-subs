class Solution {
    Trie root = new Trie();
    List<String> result = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        // build trie
        for(String w : words) {
            Trie current = root;
            
            for(int i = 0; i < w.length(); i++) {
                char c = w.charAt(i);
                current = current.next.computeIfAbsent(c, k -> new Trie());
            }
            
            current.word = w;
        }
         
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (root.next.containsKey(board[i][j])) backtracking(board, i, j, root.next.get(board[i][j]));
            }
        }
        
        return result;
    }
    
    void backtracking(char[][] board, int r, int c, Trie current) {
        if (current.word != null) {
            result.add(current.word);
            current.word = null;
        }
        
        char oc = board[r][c];
        board[r][c] = '@';
        
        for(int[] n : new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        }) {
            int nr = r + n[0];
            int nc = c + n[1];
            
            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[nr].length || !current.next.containsKey(board[nr][nc])) {
                continue;
            }
            
            char tmp = board[nr][nc];
            backtracking(board, nr, nc, current.next.get(tmp));
        }
        
        board[r][c] = oc;
        
        Set<Character> toRemove = new HashSet<>();
        
        for(Map.Entry<Character, Trie> kv : current.next.entrySet()) {
            Trie child = kv.getValue();
            if (child.word == null && child.next.isEmpty()) toRemove.add(kv.getKey());
        }
        
        for(char tr : toRemove) current.next.remove(tr);
    }
    
    class Trie {
        public String word = null;
        public Map<Character, Trie> next = new HashMap<>();
    }
}