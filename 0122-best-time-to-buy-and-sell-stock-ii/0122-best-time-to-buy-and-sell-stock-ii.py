class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        
        res = 0
        cur = float('inf')
        for p in prices:
            if p > cur:
                res += p - cur
                cur = p
            cur = min(cur, p)
            
        return res
        