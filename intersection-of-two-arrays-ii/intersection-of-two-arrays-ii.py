class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        cnt1 = collections.Counter(nums1)
        
        res = []
        
        for n in nums2:
            if cnt1.get(n, 0) > 0:
                res.append(n)
                cnt1[n] -= 1
                
        return res
        