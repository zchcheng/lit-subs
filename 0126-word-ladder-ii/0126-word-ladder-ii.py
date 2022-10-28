class Solution:
    chars = [ chr(ord('a') + i) for i in range(26) ]
    
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        graph = defaultdict(lambda: [])
        word_set = set(wordList)
        self.bfs(beginWord, endWord, word_set, graph)
        res = []
        self.backtracking(endWord, beginWord, graph, [], res)
        return res

        
    def bfs(self, begin, end, word_set, graph):
        q = []
        q.append(begin)
        
        if begin in word_set:
            word_set.remove(begin)
            
        while q:
            sz = len(q)
            wl = set()
            for i in range(sz):
                w = q.pop(0)
                if w == end:
                    break
                for i in range(len(w)):
                    for c in self.chars:
                        nw = w[:i] + c + w[i+1:]
                        if nw not in word_set:
                            continue
                        graph[nw].append(w)
                        wl.add(nw)
            for r in wl:
                word_set.remove(r)
                q.append(r)
            
        
    def backtracking(self, current_word, end, graph, stack, res):
        stack.insert(0, current_word)
        
        if current_word == end:
            res.append(stack[:])
        else:
            parents = graph[current_word]
            for parent in parents:
                self.backtracking(parent, end, graph, stack, res)
                
        stack.pop(0)
            