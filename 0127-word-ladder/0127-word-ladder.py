class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue = []
        
        word_map = defaultdict(lambda: [])
        seen = set()
        n = len(beginWord)
        
        for w in wordList:
            for i in range(n):
                word_map[w[:i] + '_' + w[i+1:]].append(w)
        
        queue.append((beginWord, 1))
        seen.add(beginWord)
        
        while queue:
            word, steps = queue.pop(0)
            
            for i in range(n):
                nw = word[:i] + '_' + word[i+1:]
                for w in word_map[nw]:
                    if w == endWord:
                        return steps + 1
                    if w in seen:
                        continue
                    queue.append((w, steps + 1))
                    seen.add(w)
                    
        return 0
                    
                    
                    
