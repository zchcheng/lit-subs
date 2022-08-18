class WordDictionary {
    Trie root = new Trie();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        Trie node = root;
        
        for(char w : word.toCharArray()) {
            node = node.next.computeIfAbsent(w, k -> new Trie());
        }
        
        node.hasWord = true;
    }
    
    public boolean search(String word) {
        Queue<Trie> queue = new LinkedList<>();
        
        queue.offer(root);
        
        for(char w : word.toCharArray()) {
            Queue<Trie> nq = new LinkedList<>();
            while(!queue.isEmpty()) {
                Trie node = queue.poll();
                if (w == '.') {
                    nq.addAll(node.next.values());
                } else {
                    Trie next = node.next.get(w);
                    if (next != null) nq.offer(next);
                }
            }
            if (nq.isEmpty()) break;
            queue = nq;
        }
        
        return queue.stream().map(i -> i.hasWord).reduce(false, (s, c) -> s || c);
    }
    
    class Trie {
        public Map<Character, Trie> next = new HashMap<>();
        public boolean hasWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */