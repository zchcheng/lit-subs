class TrieNode {
    public int wordEnding = -1;
    public Map<Character, TrieNode> next = new HashMap<>();
    public List<Integer> palindromePrefixRemaining = new ArrayList<>();
}

class Solution {
    public boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) return false;
            p1++; p2--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();

        // Build the Trie
        for (int wordId = 0; wordId < words.length; wordId++) {
            
            String word = words[wordId];
            String reversedWord = new StringBuilder(word).reverse().toString();
            
            TrieNode curNode = root;
            
            for (int j = 0; j < word.length(); j++) {
                
                if (hasPalindromeRemaining(reversedWord, j)) {
                    curNode.palindromePrefixRemaining.add(wordId);
                }
                
                char c = reversedWord.charAt(j);
                curNode = curNode.next.computeIfAbsent(c, k -> new TrieNode());
            }
            
            curNode.wordEnding = wordId;
        }

        // Find pairs
        List<List<Integer>> pairs = new ArrayList<>();
        
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            TrieNode curNode = root;
            
            for (int j = 0; j < word.length(); j++) {
                if (curNode.wordEnding != -1
                   && hasPalindromeRemaining(word, j)) {
                    pairs.add(List.of(wordId, curNode.wordEnding));
                }
                
                char c = word.charAt(j);
                curNode = curNode.next.get(c);
                if (curNode == null) break;
                
            }
            
            if (curNode == null) continue;
            
            if (curNode.wordEnding != -1 && curNode.wordEnding != wordId) {
                pairs.add(List.of(wordId, curNode.wordEnding));
            }
            
            for (int other : curNode.palindromePrefixRemaining) {
                pairs.add(List.of(wordId, other));
            }
        }

        return pairs;
    }
}