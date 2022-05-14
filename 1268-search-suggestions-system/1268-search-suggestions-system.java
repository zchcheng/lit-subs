class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        
        for(String p : products) {
            Trie head = root;
            for(char c : p.toCharArray()) {
                head = head.getNext(c);
                head.add(p);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        {
            Trie head = root;
            for(char c : searchWord.toCharArray()) {
                head = head.getNext(c);
                res.add(head.getWords());
            }
        }
        
        return res;
    }
    
    class Trie {
        public Set<String> words = new HashSet<>();
        public Map<Character, Trie> next = new HashMap<>();
        
        public Trie getNext(char c) {
            return next.computeIfAbsent(c, i -> new Trie());
        }
        
        public void add(String word) {
            words.add(word);
        }
        
        public List<String> getWords() {
            return words.stream().sorted().limit(3).collect(Collectors.toList());
        }
    }
}