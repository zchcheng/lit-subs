class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0: return ''
        if len(s) == 1: return s
            
        n = len(s)
        dp = [[False for i in range(n + 1)] for i in range(n + 1)]
        
        for i in range(n + 1):
            dp[0][i] = True
            dp[1][i] = True
        
        res = [0, 0]
        for i in range(0, n - 1):
            for j in range(i + 1, n):
                    dp[i + 2][j] = dp[i + 2][j] = s[j] == s[j - i - 1] and dp[i][j - 1]
                    if dp[i + 2][j]: res = [j - i - 1, j]
                    
        return s[res[0]: res[1] + 1]
        
                    
        
