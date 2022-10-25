class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        s = prices[0]
        r = 0
        for p in prices:
            r = max(r, p - s)
            s = min(p, s)
        return r
            