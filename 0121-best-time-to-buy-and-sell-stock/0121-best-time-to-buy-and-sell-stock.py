class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        lowest = float('inf')

        for p in prices:
            max_profit = max(max_profit, p - lowest)
            lowest = min(p, lowest)

        return max_profit
