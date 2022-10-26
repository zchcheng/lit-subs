class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        m = {0: 1}
        res = 0
        
        s = 0
        for n in nums:
            s += n
            res += m.get(s - k, 0)
            m[s] = m.get(s, 0) + 1
            
        return res