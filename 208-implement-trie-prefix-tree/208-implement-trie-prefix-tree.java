class Trie {
    Node head = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node root = head;
        
        for(char c : word.toCharArray()) {
            root = root.next.computeIfAbsent(c, k -> new Node());
        }
        
        root.hasWord = true;
    }
    
    public boolean search(String word) {
        Node result = getNode(word);
        if (result == null) return false;
        return result.hasWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    Node getNode(String word) {
        Node root = head;
        
        for(char c : word.toCharArray()) {
            if (!root.next.containsKey(c)) return null;
            root = root.next.get(c);
        }
        
        return root;
    }
    
    class Node {
        public boolean hasWord = false;
        public Map<Character, Node> next = new HashMap<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */