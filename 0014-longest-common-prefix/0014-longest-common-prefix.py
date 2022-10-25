class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        idx = 0
        
        while True:
            if idx >= len(strs[0]):
                break
            c = strs[0][idx]
            end = False
            for i in range(1, len(strs)):
                if idx >= len(strs[i]) or strs[i][idx] != c:
                    end = True
                    break
            if end:
                break
            idx += 1
            
        return strs[0][:idx]