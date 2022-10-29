class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        # [len(word1) + 1][len(word2) + 1]
        dp = [ [0 for _ in range(len(word2) + 1)] for _ in range(len(word1) + 1) ]
        
        #    '' a b c
        # ''  0 0 0 0
        #  a  0 1 1 1
        #  c  0 1 1 2
        
        for i in range(len(word1)):
            c1 = word1[i]
            
            for j in range(len(word2)):
                c2 = word2[j]
                
                if c1 == c2:
                    dp[i + 1][j + 1] = dp[i][j] + 1
                else:
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
                    
        return len(word1) + len(word2) - 2 * dp[len(word1)][len(word2)]
        
